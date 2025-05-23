package com.tencent.mobileqq.emoticon.data.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticon.data.api.ClassicFaceList;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.emoticon.data.provider.BigEmoticonDataProvider;
import com.tencent.mobileqq.emoticon.data.provider.FavEmoticonDataProvider;
import com.tencent.mobileqq.emoticon.data.provider.HotPicDataProvider;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/impl/EmoticonDataServiceImpl;", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService;", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "getSysTabInfo", "getSysAndEmojiTabInfo", "Lcom/tencent/mobileqq/emoticon/data/api/ClassicFaceList;", "getClassicEmoticonList", "", "showRecentEmoticons", "classicFaceList", "showAniSticker", "", "getSysFaceList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emojiList", "getEmojiList", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "tabType", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "callback", "updateEmoticonInfo", "getEmoticonTabInfo", "Lmqq/app/AppRuntime;", "Ljava/util/HashMap;", "dataProviders", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmoticonDataServiceImpl implements IEmoticonDataService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "EmoticonDataServiceImpl";
    private AppRuntime appRuntime;

    @NotNull
    private final HashMap<Integer, IEmoticonDataService> dataProviders;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/impl/EmoticonDataServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.api.impl.EmoticonDataServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.dataProviders = new HashMap<>();
        }
    }

    private final ClassicFaceList getClassicEmoticonList() {
        return getClassicEmoticonList(false);
    }

    private final void getEmojiList(ArrayList<EmoticonInfo> emojiList) {
        Iterator<Integer> it = QQEmojiUtil.getOrderList().iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next == null) {
                QLog.d(TAG, 1, "[getEmojiList] error, code is null!");
            } else {
                emojiList.add(new SystemAndEmojiEmoticonInfo(7, 2, next.intValue(), "", false));
            }
        }
    }

    private final List<EmoticonTabInfo> getSysAndEmojiTabInfo() {
        c cVar = new c(7, "\u7cfb\u7edf\u8868\u60c5", R.drawable.c0p);
        ClassicFaceList classicEmoticonList = getClassicEmoticonList();
        cVar.a().addAll(classicEmoticonList.getSysFaceList());
        cVar.a().addAll(classicEmoticonList.getEmojiList());
        List<EmoticonTabInfo> singletonList = Collections.singletonList(cVar);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(tabInfo)");
        return singletonList;
    }

    private final void getSysFaceList(ClassicFaceList classicFaceList, boolean showAniSticker) {
        ArrayList<Integer> orderList = QQSysFaceUtil.getOrderList();
        int size = orderList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = orderList.get(i3);
            if (num != null && num.intValue() != -1) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = new SystemAndEmojiEmoticonInfo(7, 1, num.intValue(), "", false);
                if (showAniSticker) {
                    if (SystemAndEmojiEmoticonInfo.isAniStickerEnable(num.intValue(), false)) {
                        classicFaceList.getAniStickerList().add(systemAndEmojiEmoticonInfo);
                    } else {
                        classicFaceList.getSysFaceList().add(systemAndEmojiEmoticonInfo);
                    }
                } else {
                    classicFaceList.getSysFaceList().add(systemAndEmojiEmoticonInfo);
                }
            }
        }
    }

    private final List<EmoticonTabInfo> getSysTabInfo() {
        c cVar = new c(7, "\u7cfb\u7edf\u8868\u60c5", R.drawable.c0p);
        cVar.a().addAll(getClassicEmoticonList().getSysFaceList());
        List<EmoticonTabInfo> singletonList = Collections.singletonList(cVar);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(tabInfo)");
        return singletonList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEmoticonInfo$lambda$0(IEmoticonDataService.UpdateEmoticonInfoCallback callback, EmoticonDataServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        callback.onComplete(true, this$0.getSysTabInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEmoticonInfo$lambda$1(IEmoticonDataService.UpdateEmoticonInfoCallback callback, EmoticonDataServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        callback.onComplete(true, this$0.getSysAndEmojiTabInfo());
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    @NotNull
    public List<EmoticonTabInfo> getEmoticonTabInfo(int tabType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, tabType);
        }
        IEmoticonDataService iEmoticonDataService = this.dataProviders.get(Integer.valueOf(tabType));
        if (iEmoticonDataService != null) {
            return iEmoticonDataService.getEmoticonTabInfo(tabType);
        }
        if (tabType != 1) {
            if (tabType != 7) {
                List<EmoticonTabInfo> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                return emptyList;
            }
            return getSysAndEmojiTabInfo();
        }
        return getSysTabInfo();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNull(appRuntime);
        this.appRuntime = appRuntime;
        this.dataProviders.put(12, new HotPicDataProvider());
        this.dataProviders.put(6, new BigEmoticonDataProvider());
        this.dataProviders.put(5, new FavEmoticonDataProvider());
        Iterator<IEmoticonDataService> it = this.dataProviders.values().iterator();
        while (it.hasNext()) {
            it.next().onCreate(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<IEmoticonDataService> it = this.dataProviders.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    public void updateEmoticonInfo(int tabType, @NotNull final IEmoticonDataService.UpdateEmoticonInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, tabType, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        IEmoticonDataService iEmoticonDataService = this.dataProviders.get(Integer.valueOf(tabType));
        if (iEmoticonDataService != null) {
            iEmoticonDataService.updateEmoticonInfo(tabType, callback);
            return;
        }
        if (tabType != 1) {
            if (tabType != 7) {
                List<? extends EmoticonTabInfo> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                callback.onComplete(false, emptyList);
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.data.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    EmoticonDataServiceImpl.updateEmoticonInfo$lambda$1(IEmoticonDataService.UpdateEmoticonInfoCallback.this, this);
                }
            });
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.data.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonDataServiceImpl.updateEmoticonInfo$lambda$0(IEmoticonDataService.UpdateEmoticonInfoCallback.this, this);
            }
        });
    }

    private final ClassicFaceList getClassicEmoticonList(boolean showRecentEmoticons) {
        ClassicFaceList classicFaceList = new ClassicFaceList();
        getSysFaceList(classicFaceList, false);
        getEmojiList(classicFaceList.getEmojiList());
        return classicFaceList;
    }
}
