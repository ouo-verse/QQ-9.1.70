package com.tencent.mobileqq.troop.troopsquare.topic.share;

import android.app.Activity;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler;
import com.tencent.mobileqq.troop.troopsquare.utils.ShareAction;
import com.tencent.mobileqq.troop.troopsquare.utils.b;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.IShareTopicCallback;
import com.tencent.qqnt.kernel.nativeinterface.ShareTopicReq;
import com.tencent.qqnt.kernel.nativeinterface.ShareTopicRsp;
import com.tencent.util.QQToastUtil;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0003\u0018\u001b\u001aB'\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u00101J \u0010\u0007\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J(\u0010\u000b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J2\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001b\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010#R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler;", "Lcom/tencent/mobileqq/troop/troopsquare/utils/b;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "shareType", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler$c;", "r", "T", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler$b;", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopsquare/utils/ShareAction;", "action", h.F, "f", "a", "g", "c", "b", "d", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "J", "topicId", "Ljava/lang/String;", "ext", "Lkotlinx/coroutines/Job;", "e", "Lkotlinx/coroutines/Job;", "currentJob", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "loadingDialog", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;JLjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicShareActionHandler implements com.tencent.mobileqq.troop.troopsquare.utils.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long topicId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job currentJob;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler$a;", "", "", "SHARE_TO_CHANNEL", "I", "SHARE_TO_CLIPBOARD", "SHARE_TO_FRIEND", "SHARE_TO_QZONE", "SHARE_TO_SPECIFIED_FRIEND", "SHARE_TO_WECHAT", "SHARE_TO_WECHAT_CIRCLE", "SHARE_TYPE_COPY_LINK", "SHARE_TYPE_QQ", "SHARE_TYPE_QQ_ZONE", "SHARE_TYPE_WECHAT", "SHARE_TYPE_WECHAT_MOMENTS", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler$b;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "result", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int errCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String errMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final T result;

        public b(int i3, @NotNull String errMsg, T t16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, t16);
                return;
            }
            this.errCode = i3;
            this.errMsg = errMsg;
            this.result = t16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.errCode;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.errMsg;
        }

        public final T c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (T) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.errCode == bVar.errCode && Intrinsics.areEqual(this.errMsg, bVar.errMsg) && Intrinsics.areEqual(this.result, bVar.result)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int hashCode2 = ((this.errCode * 31) + this.errMsg.hashCode()) * 31;
            T t16 = this.result;
            if (t16 == null) {
                hashCode = 0;
            } else {
                hashCode = t16.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "FetchResult(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", result=" + this.result + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "shareUrl", "b", "description", "d", "title", PhotoCategorySummaryInfo.AVATAR_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String shareUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String description;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String avatarUrl;

        public c(@NotNull String shareUrl, @NotNull String description, @NotNull String title, @NotNull String avatarUrl) {
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, shareUrl, description, title, avatarUrl);
                return;
            }
            this.shareUrl = shareUrl;
            this.description = description;
            this.title = title;
            this.avatarUrl = avatarUrl;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.avatarUrl;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.description;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.shareUrl;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.shareUrl, cVar.shareUrl) && Intrinsics.areEqual(this.description, cVar.description) && Intrinsics.areEqual(this.title, cVar.title) && Intrinsics.areEqual(this.avatarUrl, cVar.avatarUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (((((this.shareUrl.hashCode() * 31) + this.description.hashCode()) * 31) + this.title.hashCode()) * 31) + this.avatarUrl.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "UrlShareInfo(shareUrl=" + this.shareUrl + ", description=" + this.description + ", title=" + this.title + ", avatarUrl=" + this.avatarUrl + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/ShareTopicRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class d implements IShareTopicCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<b<String>> f301706a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super b<String>> continuation) {
            this.f301706a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IShareTopicCallback
        public final void onResult(int i3, String errMsg, ShareTopicRsp shareTopicRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, shareTopicRsp);
                return;
            }
            if (!JobKt.isActive(this.f301706a.get$context())) {
                this.f301706a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            Continuation<b<String>> continuation = this.f301706a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            String str = shareTopicRsp.arkJson;
            Intrinsics.checkNotNullExpressionValue(str, "result.arkJson");
            continuation.resumeWith(Result.m476constructorimpl(new b(i3, errMsg, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/ShareTopicRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class e implements IShareTopicCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<b<c>> f301707a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super b<c>> continuation) {
            this.f301707a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IShareTopicCallback
        public final void onResult(int i3, String errMsg, ShareTopicRsp shareTopicRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, shareTopicRsp);
                return;
            }
            if (!JobKt.isActive(this.f301707a.get$context())) {
                this.f301707a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            String str = shareTopicRsp.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str, "result.jumpUrl");
            String str2 = shareTopicRsp.desc;
            Intrinsics.checkNotNullExpressionValue(str2, "result.desc");
            String str3 = shareTopicRsp.title;
            Intrinsics.checkNotNullExpressionValue(str3, "result.title");
            String str4 = shareTopicRsp.picUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "result.picUrl");
            c cVar = new c(str, str2, str3, str4);
            Continuation<b<c>> continuation = this.f301707a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            continuation.resumeWith(Result.m476constructorimpl(new b(i3, errMsg, cVar)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTopicShareActionHandler(@NotNull Activity activity, @NotNull CoroutineScope coroutineScope, long j3, @NotNull String ext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(ext, "ext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, coroutineScope, Long.valueOf(j3), ext);
            return;
        }
        this.activity = activity;
        this.coroutineScope = coroutineScope;
        this.topicId = j3;
        this.ext = ext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$loadingDialog$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                Activity activity2;
                Activity activity3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QQProgressDialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                activity2 = TroopSquareTopicShareActionHandler.this.activity;
                activity3 = TroopSquareTopicShareActionHandler.this.activity;
                QQProgressDialog qQProgressDialog = new QQProgressDialog(activity2, com.tencent.mobileqq.troop.troopsetting.activity.b.a(activity3));
                qQProgressDialog.setMessage(R.string.cpr);
                qQProgressDialog.setBackAndSearchFilter(false);
                return qQProgressDialog;
            }
        });
        this.loadingDialog = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void m(b<T> result, Function1<? super T, Unit> callback) {
        if (result == null) {
            return;
        }
        if (result.a() != 0) {
            QQToastUtil.showQQToast(1, result.b());
        } else {
            callback.invoke(result.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(Continuation<? super b<String>> continuation) {
        TroopSquareTopicShareActionHandler$fetchArk$1 troopSquareTopicShareActionHandler$fetchArk$1;
        Object coroutine_suspended;
        int i3;
        TroopSquareTopicShareActionHandler troopSquareTopicShareActionHandler;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof TroopSquareTopicShareActionHandler$fetchArk$1) {
            troopSquareTopicShareActionHandler$fetchArk$1 = (TroopSquareTopicShareActionHandler$fetchArk$1) continuation;
            int i16 = troopSquareTopicShareActionHandler$fetchArk$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopSquareTopicShareActionHandler$fetchArk$1.label = i16 - Integer.MIN_VALUE;
                Object obj = troopSquareTopicShareActionHandler$fetchArk$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopSquareTopicShareActionHandler$fetchArk$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        troopSquareTopicShareActionHandler = (TroopSquareTopicShareActionHandler) troopSquareTopicShareActionHandler$fetchArk$1.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th5) {
                            th = th5;
                            troopSquareTopicShareActionHandler.p().dismiss();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        p().show();
                        troopSquareTopicShareActionHandler$fetchArk$1.L$0 = this;
                        troopSquareTopicShareActionHandler$fetchArk$1.L$1 = this;
                        troopSquareTopicShareActionHandler$fetchArk$1.L$2 = troopSquareTopicShareActionHandler$fetchArk$1;
                        troopSquareTopicShareActionHandler$fetchArk$1.label = 1;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(troopSquareTopicShareActionHandler$fetchArk$1);
                        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                        ShareTopicReq shareTopicReq = new ShareTopicReq();
                        shareTopicReq.type = 1;
                        shareTopicReq.topicId = this.topicId;
                        shareTopicReq.ext = this.ext;
                        s i17 = bg.i(null, 1, null);
                        if (i17 != null) {
                            i17.shareTopic(shareTopicReq, new d(safeContinuation));
                        }
                        obj = safeContinuation.getOrThrow();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(troopSquareTopicShareActionHandler$fetchArk$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        troopSquareTopicShareActionHandler = this;
                    } catch (Throwable th6) {
                        th = th6;
                        troopSquareTopicShareActionHandler = this;
                        troopSquareTopicShareActionHandler.p().dismiss();
                        throw th;
                    }
                }
                b bVar = (b) obj;
                troopSquareTopicShareActionHandler.p().dismiss();
                return bVar;
            }
        }
        troopSquareTopicShareActionHandler$fetchArk$1 = new TroopSquareTopicShareActionHandler$fetchArk$1(this, continuation);
        Object obj2 = troopSquareTopicShareActionHandler$fetchArk$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopSquareTopicShareActionHandler$fetchArk$1.label;
        if (i3 == 0) {
        }
        b bVar2 = (b) obj2;
        troopSquareTopicShareActionHandler.p().dismiss();
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(int i3, Continuation<? super b<c>> continuation) {
        TroopSquareTopicShareActionHandler$fetchUrl$1 troopSquareTopicShareActionHandler$fetchUrl$1;
        Object coroutine_suspended;
        int i16;
        TroopSquareTopicShareActionHandler troopSquareTopicShareActionHandler;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof TroopSquareTopicShareActionHandler$fetchUrl$1) {
            troopSquareTopicShareActionHandler$fetchUrl$1 = (TroopSquareTopicShareActionHandler$fetchUrl$1) continuation;
            int i17 = troopSquareTopicShareActionHandler$fetchUrl$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                troopSquareTopicShareActionHandler$fetchUrl$1.label = i17 - Integer.MIN_VALUE;
                Object obj = troopSquareTopicShareActionHandler$fetchUrl$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = troopSquareTopicShareActionHandler$fetchUrl$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        troopSquareTopicShareActionHandler = (TroopSquareTopicShareActionHandler) troopSquareTopicShareActionHandler$fetchUrl$1.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th5) {
                            th = th5;
                            troopSquareTopicShareActionHandler.p().dismiss();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        p().show();
                        troopSquareTopicShareActionHandler$fetchUrl$1.L$0 = this;
                        troopSquareTopicShareActionHandler$fetchUrl$1.L$1 = this;
                        troopSquareTopicShareActionHandler$fetchUrl$1.L$2 = troopSquareTopicShareActionHandler$fetchUrl$1;
                        troopSquareTopicShareActionHandler$fetchUrl$1.I$0 = i3;
                        troopSquareTopicShareActionHandler$fetchUrl$1.label = 1;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(troopSquareTopicShareActionHandler$fetchUrl$1);
                        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                        ShareTopicReq shareTopicReq = new ShareTopicReq();
                        shareTopicReq.type = i3;
                        shareTopicReq.topicId = this.topicId;
                        shareTopicReq.ext = this.ext;
                        s i18 = bg.i(null, 1, null);
                        if (i18 != null) {
                            i18.shareTopic(shareTopicReq, new e(safeContinuation));
                        }
                        obj = safeContinuation.getOrThrow();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(troopSquareTopicShareActionHandler$fetchUrl$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        troopSquareTopicShareActionHandler = this;
                    } catch (Throwable th6) {
                        th = th6;
                        troopSquareTopicShareActionHandler = this;
                        troopSquareTopicShareActionHandler.p().dismiss();
                        throw th;
                    }
                }
                b bVar = (b) obj;
                troopSquareTopicShareActionHandler.p().dismiss();
                return bVar;
            }
        }
        troopSquareTopicShareActionHandler$fetchUrl$1 = new TroopSquareTopicShareActionHandler$fetchUrl$1(this, continuation);
        Object obj2 = troopSquareTopicShareActionHandler$fetchUrl$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = troopSquareTopicShareActionHandler$fetchUrl$1.label;
        if (i16 == 0) {
        }
        b bVar2 = (b) obj2;
        troopSquareTopicShareActionHandler.p().dismiss();
        return bVar2;
    }

    private final QQProgressDialog p() {
        return (QQProgressDialog) this.loadingDialog.getValue();
    }

    private final void q(CoroutineScope coroutineScope, Function1<? super String, Unit> function1) {
        Job launch$default;
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new TroopSquareTopicShareActionHandler$withFetchedArkString$2(this, function1, null), 2, null);
            this.currentJob = launch$default;
        } else {
            QQToastUtil.showQQToast(1, this.activity.getString(R.string.f236777f_));
            this.currentJob = null;
        }
    }

    private final void r(CoroutineScope coroutineScope, int i3, Function1<? super c, Unit> function1) {
        Job launch$default;
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new TroopSquareTopicShareActionHandler$withFetchedUrl$2(this, i3, function1, null), 2, null);
            this.currentJob = launch$default;
        } else {
            QQToastUtil.showQQToast(1, this.activity.getString(R.string.f236777f_));
            this.currentJob = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void a(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            q(this.coroutineScope, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToChannel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.e(activity, it, false);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void b(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            r(this.coroutineScope, 2, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToQzone$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopSquareTopicShareActionHandler.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopSquareTopicShareActionHandler.c it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.h(activity, it.c(), it.b(), it.d(), it.a(), 5);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void c(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            r(this.coroutineScope, 4, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToWechatCircle$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopSquareTopicShareActionHandler.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopSquareTopicShareActionHandler.c it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.l(activity, it.c(), it.b(), it.d(), it.a());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void d(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            r(this.coroutineScope, 2, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToClipboard$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopSquareTopicShareActionHandler.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopSquareTopicShareActionHandler.c it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.f(activity, "troopTopicShare", it.c());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void e(@NotNull ShareAction shareAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) shareAction);
        } else {
            b.a.a(this, shareAction);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void f(@NotNull final ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            q(this.coroutineScope, new Function1<String, Unit>(action) { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToSpecifiedFriend$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ShareAction $action;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$action = action;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this, (Object) action);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    String str = this.$action.b().uin;
                    Intrinsics.checkNotNullExpressionValue(str, "action.item.uin");
                    com.tencent.mobileqq.troop.troopsquare.utils.a.i(activity, it, false, str, this.$action.b().uinType, 0);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void g(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            r(this.coroutineScope, 3, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToWechat$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopSquareTopicShareActionHandler.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopSquareTopicShareActionHandler.c it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.j(activity, it.c(), it.b(), it.d(), it.a());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsquare.utils.b
    public void h(@NotNull ShareAction action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            q(this.coroutineScope, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareActionHandler$shareToFriend$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareActionHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    activity = TroopSquareTopicShareActionHandler.this.activity;
                    com.tencent.mobileqq.troop.troopsquare.utils.a.g(activity, it, false, 1);
                }
            });
        }
    }
}
