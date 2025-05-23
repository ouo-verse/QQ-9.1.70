package com.tencent.mobileqq.vas.api.impl;

import SummaryCardTaf.SSummaryCardRsp;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.gson.Gson;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.api.IDiyCardBgUtils;
import com.tencent.mobileqq.vas.api.impl.DiyCardBgUtilsImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001%\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016JW\u0010\u001f\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u001e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018j\u0004\u0018\u0001`\u001dH\u0016R\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl;", "Lcom/tencent/mobileqq/vas/api/IDiyCardBgUtils;", "", "styleId", "backId", "", "backUrl", "color", "", "templateRet", "", "saveCardId2DB", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Landroid/net/Uri;", "enterSnapshot", "imagePath", "", "jumpToCropForResult", "filePath", "uploadBackgroundToUps", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "setCustomStyleAndBg", "isObserved", "Z", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "com/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$d", "cardObserver", "Lcom/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$d;", "<init>", "()V", "Companion", "a", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DiyCardBgUtilsImpl implements IDiyCardBgUtils {
    private static final String TAG = "DiyCardBgUtilsImpl";
    private boolean isObserved;
    private final Gson gson = new Gson();
    private final d cardObserver = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getRet", "()I", "b", "(I)V", "ret", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "msg", "<init>", "(ILjava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.impl.DiyCardBgUtilsImpl$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class SetResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int ret;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private String msg;

        public SetResult() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final void b(int i3) {
            this.ret = i3;
        }

        public int hashCode() {
            return (this.ret * 31) + this.msg.hashCode();
        }

        public String toString() {
            return "SetResult(ret=" + this.ret + ", msg=" + this.msg + ")";
        }

        public SetResult(int i3, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.ret = i3;
            this.msg = msg2;
        }

        public /* synthetic */ SetResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "\u6a21\u7248\u8d44\u6e90\u8bbe\u7f6e\u5931\u8d25" : str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetResult)) {
                return false;
            }
            SetResult setResult = (SetResult) other;
            return this.ret == setResult.ret && Intrinsics.areEqual(this.msg, setResult.msg);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308465a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f308465a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016RG\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bj\u0004\u0018\u0001`\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0010\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$d", "Lcom/tencent/mobileqq/app/CardObserver;", "Lcom/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$b;", "setResult", "", "c", "", "isSuccess", "", "obj", "onSetCardTemplateReturn", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "d", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "callback", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends CardObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Function1<Object, Unit> callback;

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Object obj, SetResult setResult, d this$0, DiyCardBgUtilsImpl this$1) {
            Intrinsics.checkNotNullParameter(setResult, "$setResult");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Card card = (Card) obj;
            long j3 = card.lCurrentStyleId;
            long j16 = card.lCurrentBgId;
            String backgroundUrl = card.backgroundUrl;
            Intrinsics.checkNotNullExpressionValue(backgroundUrl, "backgroundUrl");
            if (this$1.saveCardId2DB(j3, j16, backgroundUrl, card.backgroundColor, card.templateRet)) {
                setResult.b(0);
            }
            this$0.c(setResult);
        }

        private final void c(SetResult setResult) {
            Function1<Object, Unit> function1 = this.callback;
            if (function1 != null) {
                function1.invoke(DiyCardBgUtilsImpl.this.gson.toJson(setResult));
            }
            this.callback = null;
        }

        public final void d(Function1<Object, Unit> function1) {
            this.callback = function1;
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetCardTemplateReturn(boolean isSuccess, final Object obj) {
            int i3 = 0;
            final SetResult setResult = new SetResult(i3, null, 3, 0 == true ? 1 : 0);
            if (isSuccess && obj != null) {
                if (obj instanceof Card) {
                    final DiyCardBgUtilsImpl diyCardBgUtilsImpl = DiyCardBgUtilsImpl.this;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            DiyCardBgUtilsImpl.d.b(obj, setResult, this, diyCardBgUtilsImpl);
                        }
                    }, 16, null, true);
                    return;
                }
                if (obj instanceof Pair) {
                    Pair pair = (Pair) obj;
                    Integer num = (Integer) pair.first;
                    if (num != null && num.intValue() == 101108) {
                        setResult.b(-2);
                    } else {
                        Object obj2 = pair.first;
                        Intrinsics.checkNotNullExpressionValue(obj2, "code.first");
                        int intValue = ((Number) obj2).intValue();
                        if (400000 <= intValue && intValue < 500000) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            String str = ((SSummaryCardRsp) pair.second).emsg;
                            Intrinsics.checkNotNullExpressionValue(str, "code.second.emsg");
                            setResult.a(str);
                        }
                    }
                    c(setResult);
                    return;
                }
                return;
            }
            c(setResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean saveCardId2DB(long styleId, long backId, String backUrl, long color, int templateRet) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
        IProfileDataService iProfileDataService = (IProfileDataService) runtimeService;
        Card profileCard = iProfileDataService.getProfileCard(peekAppRuntime.getCurrentAccountUin(), false);
        if (profileCard == null || styleId < 0) {
            return false;
        }
        profileCard.lCurrentStyleId = styleId;
        profileCard.lCurrentBgId = backId;
        profileCard.strCurrentBgUrl = backUrl;
        profileCard.backgroundColor = color;
        profileCard.templateRet = templateRet;
        if (iProfileDataService.saveProfileCard(profileCard)) {
            return true;
        }
        QLog.e(TAG, 1, "save card in DB failed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCustomStyleAndBg$lambda$1(QQAppInterface app, DiyCardBgUtilsImpl this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = c.f308465a[event.ordinal()];
        if (i3 == 1) {
            app.addObserver(this$0.cardObserver, true);
            QLog.i(TAG, 2, "registerCardObserver");
        } else {
            if (i3 != 2) {
                return;
            }
            this$0.cardObserver.d(null);
            app.removeObserver(this$0.cardObserver);
            QLog.i(TAG, 2, "unregisterCardObserver");
            this$0.isObserved = false;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IDiyCardBgUtils
    public Uri enterSnapshot(Activity activity, int requestCode) {
        return ProfileCardUtils.enterSnapshot(activity, requestCode);
    }

    @Override // com.tencent.mobileqq.vas.api.IDiyCardBgUtils
    public void jumpToCropForResult(Activity activity, int requestCode, String imagePath) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        int d16 = ProfileCardUtil.d(activity);
        int c16 = ProfileCardUtil.c(activity);
        Intent intent = new Intent();
        intent.putExtra("Business_Origin", 101);
        intent.putExtra(PeakConstants.COMPRESS_QUALITY, 80);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", imagePath);
        intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.C());
        intent.putExtra(PeakConstants.CLIP_WIDTH, d16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, c16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, d16);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, c16);
        intent.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        intent.setClass(activity, PhotoCropActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override // com.tencent.mobileqq.vas.api.IDiyCardBgUtils
    public Object uploadBackgroundToUps(String str, Continuation<? super String> continuation) {
        return CoroutineScopeKt.coroutineScope(new DiyCardBgUtilsImpl$uploadBackgroundToUps$2(str, null), continuation);
    }

    @Override // com.tencent.mobileqq.vas.api.IDiyCardBgUtils
    public void setCustomStyleAndBg(Activity activity, String filePath, String url, long styleId, Function1<Object, Unit> callback) {
        LifecycleOwner a16;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(url, "url");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        this.cardObserver.d(callback);
        if (!this.isObserved) {
            if (activity != null && (a16 = nf2.b.a(activity)) != null && (lifecycle = a16.getLifecycle()) != null) {
                lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.vas.api.impl.f
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        DiyCardBgUtilsImpl.setCustomStyleAndBg$lambda$1(QQAppInterface.this, this, lifecycleOwner, event);
                    }
                });
            }
            this.isObserved = true;
        }
        ProfileCardUtil.v0(qQAppInterface, styleId, 0L, url, ProfileCardUtil.a(filePath), null);
    }
}
