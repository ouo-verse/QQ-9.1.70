package com.tencent.mobileqq.flock.publish.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.flock.publish.request.FlockGetPublishInfoRequest;
import com.tencent.mobileqq.flock.publish.request.FlockModifyFeedRequest;
import com.tencent.mobileqq.flock.publish.request.FlockPublishFeedRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u0001:\u0002UVB\u000f\u0012\u0006\u0010Q\u001a\u00020P\u00a2\u0006\u0004\bR\u0010SJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J)\u0010\u001c\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u001c\u0010\u001f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0007H\u0014J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020&0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010(R4\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010;R\u0014\u0010I\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0017\u0010O\u001a\u00020J8\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/f;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishBaseViewModel;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaList", "", "m2", "", "u2", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "p2", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "r2", "Ly45/b;", "feed", ICustomDataEditor.STRING_PARAM_2, ICustomDataEditor.NUMBER_PARAM_2, "d2", "Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "mediaInfo", "", "path", "Ly45/i;", "f2", "", "images", "url", "e2", "([Ly45/i;Ljava/lang/String;)Ly45/i;", "getLogTag", "q2", "k2", "onCleared", MosaicConstants$JsFunction.FUNC_ON_DESTROY, SemanticAttributes.DbSystemValues.H2, "c2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/f$b;", "E", "Landroidx/lifecycle/MutableLiveData;", "_updateUI", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "l2", "()Landroidx/lifecycle/LiveData;", "setUpdateUI", "(Landroidx/lifecycle/LiveData;)V", "updateUI", "Lkotlin/Pair;", "G", "_checkSuccess", "H", "g2", "setCheckSuccess", "checkSuccess", "I", "Ljava/util/List;", "J", "Ly45/b;", "K", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "L", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "publishService", "", "M", "groupId", "N", "Z", "isModify", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "P", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "j2", "()Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "taskListener", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends FlockPublishBaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _updateUI;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private LiveData<b> updateUI;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, String>> _checkSuccess;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private LiveData<Pair<Boolean, String>> checkSuccess;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<? extends LocalMediaInfo> mediaList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private y45.b feed;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TaskInfo taskInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private WinkPublishServiceProxy2 publishService;

    /* renamed from: M, reason: from kotlin metadata */
    private final long groupId;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean isModify;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ITaskListener.Stub taskListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/f$a;", "", "", "TAG", "Ljava/lang/String;", "", "UPLOAD_FAIL", "J", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.viewmodel.f$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\n\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/f$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ly45/b;", "a", "Ly45/b;", "b", "()Ly45/b;", "feed", "I", "c", "()I", "from", "Z", "e", "()Z", "isModify", "d", "f", "isSuccess", "", "J", "()J", "retCode", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(Ly45/b;IZZJLjava/lang/String;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final y45.b feed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int from;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isModify;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long retCode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String errMsg;

        public b(@Nullable y45.b bVar, int i3, boolean z16, boolean z17, long j3, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), errMsg);
                return;
            }
            this.feed = bVar;
            this.from = i3;
            this.isModify = z16;
            this.isSuccess = z17;
            this.retCode = j3;
            this.errMsg = errMsg;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.errMsg;
        }

        @Nullable
        public final y45.b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (y45.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.feed;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.from;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.retCode;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isModify;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.feed, bVar.feed) && this.from == bVar.from && this.isModify == bVar.isModify && this.isSuccess == bVar.isSuccess && this.retCode == bVar.retCode && Intrinsics.areEqual(this.errMsg, bVar.errMsg)) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            y45.b bVar = this.feed;
            if (bVar == null) {
                hashCode = 0;
            } else {
                hashCode = bVar.hashCode();
            }
            int i3 = ((hashCode * 31) + this.from) * 31;
            boolean z16 = this.isModify;
            int i16 = 1;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i3 + i17) * 31;
            boolean z17 = this.isSuccess;
            if (!z17) {
                i16 = z17 ? 1 : 0;
            }
            return ((((i18 + i16) * 31) + androidx.fragment.app.a.a(this.retCode)) * 31) + this.errMsg.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "PublishResult(feed=" + this.feed + ", from=" + this.from + ", isModify=" + this.isModify + ", isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", errMsg=" + this.errMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flock/publish/viewmodel/f$c", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "", "onTaskChange", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends ITaskListener.Stub {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@NotNull TaskInfo task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            TaskInfo taskInfo = f.this.taskInfo;
            boolean z16 = false;
            if (taskInfo != null && task.getTaskId() == taskInfo.getTaskId()) {
                z16 = true;
            }
            if (z16) {
                WinkPublishServiceProxy2 winkPublishServiceProxy2 = null;
                if (task.isFinish()) {
                    f.this.r2(task);
                    WinkPublishServiceProxy2 winkPublishServiceProxy22 = f.this.publishService;
                    if (winkPublishServiceProxy22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishService");
                    } else {
                        winkPublishServiceProxy2 = winkPublishServiceProxy22;
                    }
                    winkPublishServiceProxy2.removeTaskListener(this);
                    return;
                }
                if (task.isCancelled()) {
                    f.this._updateUI.postValue(new b(null, f.this.N1(), f.this.isModify, false, -999999L, "\u53d6\u6d88\u4e0a\u4f20"));
                    WinkPublishServiceProxy2 winkPublishServiceProxy23 = f.this.publishService;
                    if (winkPublishServiceProxy23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishService");
                    } else {
                        winkPublishServiceProxy2 = winkPublishServiceProxy23;
                    }
                    winkPublishServiceProxy2.removeTaskListener(this);
                    return;
                }
                if (task.isNetworkWaiting()) {
                    f.this._updateUI.postValue(new b(null, f.this.N1(), f.this.isModify, false, -999999L, "\u65e0\u7f51\u7edc"));
                    f.this.c2();
                    WinkPublishServiceProxy2 winkPublishServiceProxy24 = f.this.publishService;
                    if (winkPublishServiceProxy24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishService");
                    } else {
                        winkPublishServiceProxy2 = winkPublishServiceProxy24;
                    }
                    winkPublishServiceProxy2.removeTaskListener(this);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flock/publish/viewmodel/f$d", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements WinkPublishHelper2.Callback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) service);
                return;
            }
            Intrinsics.checkNotNullParameter(service, "service");
            f.this.publishService = service;
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = f.this.publishService;
            if (winkPublishServiceProxy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishService");
                winkPublishServiceProxy2 = null;
            }
            winkPublishServiceProxy2.addTaskListener2(f.this.j2());
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            f.this.taskInfo = service.addTask(new WinkPublishParams(13, uuid, f.this.k2(), false, 23, f.this.p2(), null, null, null, null, 968, null));
            QLog.d("FlockPublishSendViewModel", 1, "uploadImages... taskInfo:" + f.this.taskInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        if ((!r5) == true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(@NotNull Intent intent) {
        super(intent);
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._updateUI = mutableLiveData;
        this.updateUI = mutableLiveData;
        MutableLiveData<Pair<Boolean, String>> mutableLiveData2 = new MutableLiveData<>();
        this._checkSuccess = mutableLiveData2;
        this.checkSuccess = mutableLiveData2;
        this.mediaList = new ArrayList();
        this.feed = new y45.b();
        this.groupId = intent.getLongExtra("key_flock_group_id", 0L);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_flock_detail_feed");
        if (byteArrayExtra != null) {
            if (byteArrayExtra.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        this.isModify = z17;
        this.taskListener = new c();
    }

    private final y45.b d2(TaskInfo task) {
        List<MediaInfo> list;
        int size = this.mediaList.size();
        y45.i[] iVarArr = new y45.i[size];
        for (int i3 = 0; i3 < size; i3++) {
            iVarArr[i3] = new y45.i();
        }
        int size2 = this.mediaList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            if (com.tencent.mobileqq.flock.ktx.g.a(this.mediaList.get(i16).path)) {
                iVarArr[i16] = e2(this.feed.f449375j, this.mediaList.get(i16).path);
            } else {
                if (task != null) {
                    list = task.getMediaInfos();
                } else {
                    list = null;
                }
                String str = this.mediaList.get(i16).path;
                Intrinsics.checkNotNullExpressionValue(str, "mediaList[i].path");
                y45.i f26 = f2(list, str);
                if (f26 != null) {
                    iVarArr[i16] = f26;
                }
            }
        }
        y45.b bVar = this.feed;
        bVar.f449375j = iVarArr;
        return bVar;
    }

    private final y45.i e2(y45.i[] images, String url) {
        y45.i iVar;
        if (images != null) {
            int length = images.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    iVar = images[i3];
                    if (Intrinsics.areEqual(iVar.f449405c, url)) {
                        break;
                    }
                    i3++;
                } else {
                    iVar = null;
                    break;
                }
            }
            if (iVar != null) {
                return iVar;
            }
        }
        return new y45.i();
    }

    private final y45.i f2(List<MediaInfo> mediaInfo, String path) {
        Object obj;
        ImageResult imageResult = null;
        if (mediaInfo == null) {
            return null;
        }
        Iterator<T> it = mediaInfo.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MediaInfo) obj).getMediaPath(), path)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaInfo mediaInfo2 = (MediaInfo) obj;
        if (mediaInfo2 == null) {
            return null;
        }
        y45.i iVar = new y45.i();
        MediaUploadResult uploadResult = mediaInfo2.getUploadResult();
        if (uploadResult instanceof ImageResult) {
            imageResult = (ImageResult) uploadResult;
        }
        if (imageResult != null) {
            iVar.f449405c = imageResult.getOriginUrl();
            iVar.f449408f = imageResult.getMd5();
            iVar.f449403a = imageResult.getOriginWidth();
            iVar.f449404b = imageResult.getOriginHeight();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(f this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, z45.j jVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        QLog.d("FlockPublishSendViewModel", 1, "getPublishInfo... isSuccess:" + z16 + " retCode:" + j3 + " errMsg:" + errMsg);
        if ((!z16 || j3 != 0) && j3 >= 20000) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            if (errMsg.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                this$0._checkSuccess.postValue(new Pair<>(Boolean.FALSE, errMsg));
            }
        }
    }

    private final boolean m2(List<? extends LocalMediaInfo> mediaList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : mediaList) {
            if (com.tencent.mobileqq.flock.ktx.g.a(((LocalMediaInfo) obj).path)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != mediaList.size()) {
            return true;
        }
        return false;
    }

    private final void n2(y45.b feed) {
        y45.d dVar = new y45.d();
        dVar.f449388a = System.currentTimeMillis() / 1000;
        feed.f449378m = dVar;
        VSNetworkHelper.getInstance().sendRequest(new FlockModifyFeedRequest(feed), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                f.o2(f.this, baseRequest, z16, j3, str, (a55.f) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(f this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, a55.f fVar) {
        y45.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<b> mutableLiveData = this$0._updateUI;
        if (fVar != null) {
            bVar = fVar.f25559a;
        } else {
            bVar = null;
        }
        int N1 = this$0.N1();
        boolean z17 = this$0.isModify;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        mutableLiveData.postValue(new b(bVar, N1, z17, z16, j3, errMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MediaParams> p2() {
        ArrayList arrayList = new ArrayList();
        int size = this.mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            LocalMediaInfo localMediaInfo = this.mediaList.get(i3);
            if (AlbumUtil.isImage(localMediaInfo) && !com.tencent.mobileqq.flock.ktx.g.a(localMediaInfo.path)) {
                arrayList.add(ImageParams.INSTANCE.from(localMediaInfo, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(TaskInfo task) {
        QLog.d("FlockPublishSendViewModel", 1, "publishFeed... isModify:" + this.isModify);
        y45.b d26 = d2(task);
        if (this.isModify) {
            n2(d26);
        } else {
            s2(d26);
        }
    }

    private final void s2(y45.b feed) {
        VSNetworkHelper.getInstance().sendRequest(new FlockPublishFeedRequest(feed, N1()), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                f.t2(f.this, baseRequest, z16, j3, str, (a55.h) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(f this$0, BaseRequest baseRequest, boolean z16, long j3, String errMsg, a55.h hVar) {
        y45.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<b> mutableLiveData = this$0._updateUI;
        if (hVar != null) {
            bVar = hVar.f25562a;
        } else {
            bVar = null;
        }
        int N1 = this$0.N1();
        boolean z17 = this$0.isModify;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        mutableLiveData.postValue(new b(bVar, N1, z17, z16, j3, errMsg));
    }

    private final void u2() {
        WinkPublishHelper2.INSTANCE.bindService(13, new d());
    }

    public final void c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        TaskInfo taskInfo = this.taskInfo;
        if (taskInfo != null) {
            long taskId = taskInfo.getTaskId();
            QLog.d("FlockPublishSendViewModel", 1, "cancelUpload... taskId:" + taskId);
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.publishService;
            if (winkPublishServiceProxy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishService");
                winkPublishServiceProxy2 = null;
            }
            if (winkPublishServiceProxy2 != null) {
                winkPublishServiceProxy2.cancelTaskWithId(taskId);
            }
        }
    }

    @NotNull
    public final LiveData<Pair<Boolean, String>> g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.checkSuccess;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "FlockPublishSendViewModel";
    }

    public final void h2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.isModify) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        VSNetworkHelper.getInstance().sendRequest(new FlockGetPublishInfoRequest(i3), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.e
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                f.i2(f.this, baseRequest, z16, j3, str, (z45.j) obj);
            }
        });
    }

    @NotNull
    public final ITaskListener.Stub j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ITaskListener.Stub) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.taskListener;
    }

    @NotNull
    public final String k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String format = new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + format + "_" + UUID.randomUUID();
        QLog.d("FlockPublishSendViewModel", 1, "traceId:" + str);
        return str;
    }

    @NotNull
    public final LiveData<b> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.updateUI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onCleared();
        }
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        TaskInfo taskInfo = this.taskInfo;
        if (taskInfo != null) {
            long taskId = taskInfo.getTaskId();
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.publishService;
            if (winkPublishServiceProxy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishService");
                winkPublishServiceProxy2 = null;
            }
            if (winkPublishServiceProxy2 != null) {
                winkPublishServiceProxy2.cancelTaskWithId(taskId);
            }
        }
    }

    public final void q2(@NotNull List<? extends LocalMediaInfo> mediaList, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mediaList, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.mediaList = mediaList;
        feed.f449373h = System.currentTimeMillis() / 1000;
        if (!this.isModify) {
            o oVar = new o();
            oVar.f449449a = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            feed.f449369d = oVar;
        }
        feed.f449368c = this.groupId;
        feed.f449370e = !mediaList.isEmpty() ? 1 : 0;
        this.feed = feed;
        if ((!mediaList.isEmpty()) && m2(mediaList)) {
            u2();
        } else {
            r2(null);
        }
    }
}
