package com.tencent.state.square.components.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.state.event.SquareSharePosterEvent;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasGetPosterService;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.IShareUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareMainPosterShareInfo;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.view.VasSquareMainShareView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010\u0017\u001a\u00020\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareShareComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onFragmentDestroyed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onReceiveEvent", "event", "share", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareShareComponent extends SquareBaseComponent implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final String TAG = "SquareShareComponent";
    private VasSquareFragmentSquareBinding binding;

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(SquareSharePosterEvent.class);
        return arrayList;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        VasSquareMainShareView vasSquareMainShareView;
        Intrinsics.checkNotNullParameter(f16, "f");
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (vasSquareMainShareView = vasSquareFragmentSquareBinding.poster) != null) {
            vasSquareMainShareView.clearPosterTempFile();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
        VasGetPosterService.INSTANCE.getSquareShareData(new ResultCallback<SquareMainPosterShareInfo>() { // from class: com.tencent.state.square.components.fragment.SquareShareComponent$onFragmentViewCreated$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareShareComponent", "file load fail: " + error + ", " + message, null, 4, null);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareMainPosterShareInfo result) {
                VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
                VasSquareMainShareView vasSquareMainShareView;
                Intrinsics.checkNotNullParameter(result, "result");
                vasSquareFragmentSquareBinding = SquareShareComponent.this.binding;
                if (vasSquareFragmentSquareBinding == null || (vasSquareMainShareView = vasSquareFragmentSquareBinding.poster) == null) {
                    return;
                }
                vasSquareMainShareView.bindPosterView(result);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        SquareBaseKt.getSquareLog().i(TAG, "onReceiveEvent: " + event);
        if ((event instanceof SquareSharePosterEvent) && ((SquareSharePosterEvent) event).getIsShare()) {
            ZTPSquareRewardService.INSTANCE.finishShareTask(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareShareComponent$onReceiveEvent$1
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void share() {
        VasSquareMainShareView vasSquareMainShareView;
        Bitmap convertToBitMap;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
        VasSquareMainShareView vasSquareMainShareView2;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
        if (vasSquareFragmentSquareBinding2 == null || (vasSquareMainShareView = vasSquareFragmentSquareBinding2.poster) == null || (convertToBitMap = vasSquareMainShareView.convertToBitMap()) == null || (vasSquareFragmentSquareBinding = this.binding) == null || (vasSquareMainShareView2 = vasSquareFragmentSquareBinding.poster) == null) {
            return;
        }
        vasSquareMainShareView2.getPosterTempFile(convertToBitMap, new Function1<File, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareShareComponent$share$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                if (file.exists()) {
                    IShareUtils squareShareUtil = SquareBaseKt.getSquareShareUtil();
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath == null) {
                        absolutePath = "";
                    }
                    IShareUtils.DefaultImpls.doShare$default(squareShareUtil, null, absolutePath, 0, new Integer[]{0, 1, 2, 3}, new Integer[0], 0, 5, null);
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareShareComponent", "file load fail", null, 4, null);
            }
        });
    }
}
