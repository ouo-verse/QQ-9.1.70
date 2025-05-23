package com.tencent.qqlive.tvkplayer.qqliveasset.trigger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKOnFunctionCompleteListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseInterruptFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8.TVKNestM3u8SelectAudioTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularAdaptiveDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSelectAudioTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSelectSubtitleTrackFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.TVKRegularSwitchDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalDataTransportUnavailableFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalMediaAssetExpiredFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalMediaAssetExpiredWithReopenFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalPlayerErrorRetryFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalRefreshPlayerFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalRefreshPlayerWithReopenFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalReopenSwitchDefinitionFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalSeekLiveFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalSimulatedLiveFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFunctionOverrideRegister;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes23.dex */
public class TVKQQLiveAssetPlayerTrigger implements ITVKPlayerTrigger {
    private static final String TAG = "TVKPlayerTrigger";
    private final Comparator<TriggerMatcherAndFunction> mFunctionListComparator;
    private final ITVKLogger mLogger;
    private final ITVKOnFunctionCompleteListener mOnFunctionCompleteListener;
    private final List<TriggerMatcherAndFunction> mFunctionMatcherList = new ArrayList();
    private final List<ITVKFunction> mActivatedFunctionList = new CopyOnWriteArrayList();
    private final List<TVKFunctionRecord> mFunctionRecordList = new CopyOnWriteArrayList();

    /* loaded from: classes23.dex */
    private static class FunctionComparator implements Comparator<TriggerMatcherAndFunction> {
        FunctionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TriggerMatcherAndFunction triggerMatcherAndFunction, TriggerMatcherAndFunction triggerMatcherAndFunction2) {
            int i3 = triggerMatcherAndFunction.getFunction().getTargetAssetType() == 1 ? 4 : 0;
            int i16 = triggerMatcherAndFunction2.getFunction().getTargetAssetType() != 1 ? 0 : 4;
            if (triggerMatcherAndFunction.getFunction().getType() == 1) {
                i3 |= 128;
            }
            if (triggerMatcherAndFunction2.getFunction().getType() == 1) {
                i16 |= 128;
            }
            return i16 - i3;
        }
    }

    /* loaded from: classes23.dex */
    private class OnFunctionCompleteListener implements ITVKOnFunctionCompleteListener {
        OnFunctionCompleteListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKOnFunctionCompleteListener
        public void onComplete(@NonNull ITVKFunction iTVKFunction) {
            iTVKFunction.reset();
            if (!TVKQQLiveAssetPlayerTrigger.this.isNeedExecuteRecordFunction(iTVKFunction)) {
                TVKQQLiveAssetPlayerTrigger.this.mActivatedFunctionList.remove(iTVKFunction);
                return;
            }
            TVKQQLiveAssetPlayerTrigger.this.mActivatedFunctionList.remove(iTVKFunction);
            for (TVKFunctionRecord tVKFunctionRecord : TVKQQLiveAssetPlayerTrigger.this.mFunctionRecordList) {
                try {
                    ITVKFunction function = tVKFunctionRecord.getFunction();
                    TVKQQLiveAssetPlayerTrigger.this.mLogger.info("execute record function when function is finished! function=" + function.getClass().getSimpleName(), new Object[0]);
                    if (!TVKQQLiveAssetPlayerTrigger.this.isNeedToDelayExecute(function)) {
                        TVKQQLiveAssetPlayerTrigger.this.terminatedCurrentFunctionWhenAccompanyFunctionBeTrigger(function);
                        TVKQQLiveAssetPlayerTrigger.this.removeOverrideRecordFunctionWhenAccompanyFunctionBeTrigger(function);
                        function.execute(tVKFunctionRecord.getAssetPlayerContext(), tVKFunctionRecord.getMethod(), tVKFunctionRecord.getArgs());
                        TVKQQLiveAssetPlayerTrigger.this.mFunctionRecordList.remove(tVKFunctionRecord);
                        TVKQQLiveAssetPlayerTrigger.this.mActivatedFunctionList.add(function);
                    }
                } catch (Exception e16) {
                    TVKQQLiveAssetPlayerTrigger.this.mLogger.printException(e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class TriggerMatcherAndFunction {

        @NonNull
        private final ITVKFunction mFunction;

        @NonNull
        private final TVKMethodMatcher mMethodMatcher;

        public TriggerMatcherAndFunction(@NonNull TVKMethodMatcher tVKMethodMatcher, @NonNull ITVKFunction iTVKFunction) {
            this.mMethodMatcher = tVKMethodMatcher;
            this.mFunction = iTVKFunction;
        }

        @NonNull
        public ITVKFunction getFunction() {
            return this.mFunction;
        }

        @NonNull
        public TVKMethodMatcher getMethodMatcher() {
            return this.mMethodMatcher;
        }
    }

    public TVKQQLiveAssetPlayerTrigger(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mFunctionListComparator = new FunctionComparator();
        this.mOnFunctionCompleteListener = new OnFunctionCompleteListener();
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKUniversalPlayerErrorRetryFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalRefreshPlayerFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalRefreshPlayerWithReopenFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalSeekLiveFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalReopenSwitchDefinitionFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalDataTransportUnavailableFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalMediaAssetExpiredWithReopenFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalMediaAssetExpiredFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKUniversalSimulatedLiveFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKRegularSwitchDefinitionFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKRegularAdaptiveDefinitionFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKNestM3u8SelectAudioTrackFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKRegularSelectSubtitleTrackFunction(tVKQQLiveAssetPlayerContext));
        arrayList.add(new TVKRegularSelectAudioTrackFunction(tVKQQLiveAssetPlayerContext));
        registerAllFunction(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedExecuteRecordFunction(@NonNull ITVKFunction iTVKFunction) {
        if (this.mFunctionRecordList.isEmpty()) {
            return false;
        }
        if (iTVKFunction.getType() == 1) {
            this.mLogger.info("interruptFunction:" + iTVKFunction.getClass().getSimpleName() + " is finished and need to execute record function", new Object[0]);
            return true;
        }
        Iterator<TVKFunctionRecord> it = this.mFunctionRecordList.iterator();
        while (it.hasNext()) {
            if (TVKFunctionOverrideRegister.isNeedWaitActivatedFunctionBeforeExecuteFunction(((TVKBaseAccompanyFunction) it.next().getFunction()).getClass(), ((TVKBaseAccompanyFunction) iTVKFunction).getClass())) {
                this.mLogger.info("waitFunction:" + iTVKFunction.getClass().getSimpleName() + " is finished and need to execute record function", new Object[0]);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedToDelayExecute(ITVKFunction iTVKFunction) {
        if (isNeedToDelayExecuteForWaitActivated(iTVKFunction)) {
            return true;
        }
        if (!this.mActivatedFunctionList.isEmpty() && this.mActivatedFunctionList.get(0).getType() == 1 && iTVKFunction.getType() != 1) {
            return true;
        }
        return false;
    }

    private boolean isNeedToDelayExecuteForWaitActivated(ITVKFunction iTVKFunction) {
        if (iTVKFunction.getType() == 1 || this.mActivatedFunctionList.isEmpty()) {
            return false;
        }
        for (ITVKFunction iTVKFunction2 : this.mActivatedFunctionList) {
            if (iTVKFunction2.getType() == 1) {
                this.mLogger.info("find " + iTVKFunction.getClass().getSimpleName() + ", but need to wait interrupt function done", new Object[0]);
                return true;
            }
            if (TVKFunctionOverrideRegister.isNeedWaitActivatedFunctionBeforeExecuteFunction(((TVKBaseAccompanyFunction) iTVKFunction).getClass(), ((TVKBaseAccompanyFunction) iTVKFunction2).getClass())) {
                this.mLogger.info("find " + iTVKFunction.getClass().getSimpleName() + ", but need to wait " + iTVKFunction2.getClass().getSimpleName(), new Object[0]);
                return true;
            }
        }
        return false;
    }

    private void recordCurrentFunctionWhenInterruptFunctionBeTrigger(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull ITVKFunction iTVKFunction) {
        if (iTVKFunction.getType() == 0) {
            return;
        }
        for (ITVKFunction iTVKFunction2 : this.mActivatedFunctionList) {
            iTVKFunction2.cancel();
            iTVKFunction2.reset();
            this.mActivatedFunctionList.remove(iTVKFunction2);
            if (iTVKFunction2.getType() != 1) {
                if (TVKFunctionOverrideRegister.isAccompanyFunctionOverrideByExecuteInterruptFunction(((TVKBaseInterruptFunction) iTVKFunction).getClass(), ((TVKBaseAccompanyFunction) iTVKFunction2).getClass())) {
                    this.mLogger.info("exeFunction class=" + iTVKFunction.getClass().getSimpleName() + " has override activatedFunction class=" + iTVKFunction2.getClass().getSimpleName(), new Object[0]);
                } else {
                    this.mFunctionRecordList.add(new TVKFunctionRecord(iTVKFunction2, tVKQQLiveAssetPlayerContext));
                }
            }
        }
        for (TVKFunctionRecord tVKFunctionRecord : this.mFunctionRecordList) {
            ITVKFunction function = tVKFunctionRecord.getFunction();
            if (TVKFunctionOverrideRegister.isAccompanyFunctionOverrideByExecuteInterruptFunction(((TVKBaseInterruptFunction) iTVKFunction).getClass(), ((TVKBaseAccompanyFunction) function).getClass())) {
                this.mFunctionRecordList.remove(tVKFunctionRecord);
                this.mLogger.info("exeFunction class=" + iTVKFunction.getClass().getSimpleName() + " has override recordFunction class=" + function.getClass().getSimpleName(), new Object[0]);
            }
        }
    }

    private void registerAllFunction(@NonNull List<ITVKFunction> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ITVKFunction iTVKFunction : list) {
            Iterator<TVKMethodMatcher> it = iTVKFunction.getTriggerMatcherList().iterator();
            while (it.hasNext()) {
                this.mFunctionMatcherList.add(new TriggerMatcherAndFunction(it.next(), iTVKFunction));
            }
            iTVKFunction.setOnCompleteListener(this.mOnFunctionCompleteListener);
            if (iTVKFunction.getType() == 0) {
                arrayList2.add(((TVKBaseAccompanyFunction) iTVKFunction).getClass());
            } else if (iTVKFunction.getType() == 1) {
                arrayList.add(((TVKBaseInterruptFunction) iTVKFunction).getClass());
            } else {
                throw new RuntimeException("function=" + iTVKFunction.getClass().getSimpleName() + " has illegal type=" + iTVKFunction.getType());
            }
        }
        TVKFunctionOverrideRegister.checkFunctionOverrideRegisterValid(arrayList, arrayList2);
        Collections.sort(this.mFunctionMatcherList, this.mFunctionListComparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOverrideRecordFunctionWhenAccompanyFunctionBeTrigger(@NonNull ITVKFunction iTVKFunction) {
        if (iTVKFunction.getType() == 1) {
            return;
        }
        for (TVKFunctionRecord tVKFunctionRecord : this.mFunctionRecordList) {
            ITVKFunction function = tVKFunctionRecord.getFunction();
            if (TVKFunctionOverrideRegister.isAccompanyFunctionOverrideByExecuteAccompanyFunction(((TVKBaseAccompanyFunction) iTVKFunction).getClass(), ((TVKBaseAccompanyFunction) function).getClass())) {
                this.mFunctionRecordList.remove(tVKFunctionRecord);
                this.mLogger.info("exeFunction class=" + iTVKFunction.getClass().getSimpleName() + " has override recordFunction class=" + function.getClass().getSimpleName(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void terminatedCurrentFunctionWhenAccompanyFunctionBeTrigger(@NonNull ITVKFunction iTVKFunction) {
        if (iTVKFunction.getType() == 1) {
            return;
        }
        for (ITVKFunction iTVKFunction2 : this.mActivatedFunctionList) {
            if (iTVKFunction2.getType() != 1 && TVKFunctionOverrideRegister.isAccompanyFunctionOverrideByExecuteAccompanyFunction(((TVKBaseAccompanyFunction) iTVKFunction).getClass(), ((TVKBaseAccompanyFunction) iTVKFunction2).getClass())) {
                iTVKFunction2.cancel();
                iTVKFunction2.reset();
                this.mActivatedFunctionList.remove(iTVKFunction2);
                this.mLogger.info("exeFunction class=" + iTVKFunction.getClass().getSimpleName() + " has override activatedFunction class=" + iTVKFunction2.getClass().getSimpleName(), new Object[0]);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger
    @Nullable
    public Object executeFunction(@NonNull ITVKFunction iTVKFunction, @NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        terminatedCurrentFunctionWhenAccompanyFunctionBeTrigger(iTVKFunction);
        removeOverrideRecordFunctionWhenAccompanyFunctionBeTrigger(iTVKFunction);
        recordCurrentFunctionWhenInterruptFunctionBeTrigger(tVKQQLiveAssetPlayerContext, iTVKFunction);
        if (isNeedToDelayExecute(iTVKFunction)) {
            this.mFunctionRecordList.add(new TVKFunctionRecord(iTVKFunction, tVKQQLiveAssetPlayerContext, method, objArr));
            return null;
        }
        if (this.mActivatedFunctionList.contains(iTVKFunction)) {
            this.mLogger.info("exeFunction=" + iTVKFunction + " already activated!do not add to mActivatedFunctionList", new Object[0]);
        } else {
            this.mActivatedFunctionList.add(iTVKFunction);
        }
        try {
            return iTVKFunction.execute(tVKQQLiveAssetPlayerContext, method, objArr);
        } catch (Exception e16) {
            this.mOnFunctionCompleteListener.onComplete(iTVKFunction);
            throw e16;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger
    @NonNull
    public List<ITVKFunction> findConsumeNotificationFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (ITVKFunction iTVKFunction : this.mActivatedFunctionList) {
            for (TVKMethodMatcher tVKMethodMatcher : iTVKFunction.getNotificationMatcherList()) {
                if (tVKMethodMatcher.isMatch(tVKQQLiveAssetPlayerContext, method, objArr) && (tVKMethodMatcher.getStateMatcher() == null || tVKMethodMatcher.getStateMatcher().isMatch(tVKQQLiveAssetPlayerContext.getState()))) {
                    arrayList.add(iTVKFunction);
                    break;
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger
    public ITVKPlayerTrigger.FunctionStateMatcher findExecuteFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) {
        for (TriggerMatcherAndFunction triggerMatcherAndFunction : this.mFunctionMatcherList) {
            if (triggerMatcherAndFunction.getMethodMatcher().isMatch(tVKQQLiveAssetPlayerContext, method, objArr)) {
                return new ITVKPlayerTrigger.FunctionStateMatcher(triggerMatcherAndFunction.mFunction, triggerMatcherAndFunction.getMethodMatcher().getStateMatcher());
            }
        }
        return new ITVKPlayerTrigger.FunctionStateMatcher(null, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger
    public ITVKFunction findTakeOverFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) {
        for (ITVKFunction iTVKFunction : this.mActivatedFunctionList) {
            for (TVKMethodMatcher tVKMethodMatcher : iTVKFunction.getTakeOverMethodMatcherList()) {
                if (tVKMethodMatcher.isMatch(tVKQQLiveAssetPlayerContext, method, objArr) && (tVKMethodMatcher.getStateMatcher() == null || tVKMethodMatcher.getStateMatcher().isMatch(tVKQQLiveAssetPlayerContext.getState()))) {
                    return iTVKFunction;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger
    public void reset() {
        this.mLogger.info("trigger reset", new Object[0]);
        for (ITVKFunction iTVKFunction : this.mActivatedFunctionList) {
            iTVKFunction.cancel();
            iTVKFunction.reset();
        }
        this.mActivatedFunctionList.clear();
        this.mFunctionRecordList.clear();
    }
}
