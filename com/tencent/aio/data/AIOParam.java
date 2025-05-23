package com.tencent.aio.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ts.b;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 :2\u00020\u0001:\u0002;<B\u0007\u00a2\u0006\u0004\b8\u0010*B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b8\u00109J\u0006\u0010\u0003\u001a\u00020\u0002J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\u0010\u0010\tJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u001e\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b(\u0010%\u0012\u0004\b)\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "Landroid/os/Parcelable;", "", DomainData.DOMAIN_NAME, "", "o", "()Ljava/util/List;", "", ReportConstant.COSTREPORT_PREFIX, "()Z", "Lcom/tencent/aio/data/AIOSession;", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "l", "k", "p", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "Lcom/tencent/aio/data/AIOSession;", "mSession", "e", "I", "mEnterExtPanel", "f", "Landroid/os/Bundle;", "mExtBundle", h.F, "Z", "mCacheable", "i", "Ljava/lang/String;", "mCacheKey", "mIsPreLoad", BdhLogUtil.LogTag.Tag_Conn, "getMFirstScreenHelperName$annotations", "()V", "mFirstScreenHelperName", "", "D", "Ljava/util/List;", "mFactoryNames", "Lts/b;", "E", "Lts/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lts/b;", "t", "(Lts/b;)V", "mAIOAssistanceService", "<init>", "(Landroid/os/Parcel;)V", "CREATOR", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOParam implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private String mFirstScreenHelperName;

    /* renamed from: D, reason: from kotlin metadata */
    private List<String> mFactoryNames;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b mAIOAssistanceService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOSession mSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mEnterExtPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Bundle mExtBundle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mCacheable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mCacheKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPreLoad;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J#\u0010\u0005\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/aio/data/AIOParam$a;", "", "", "", "factoryNames", "f", "([Ljava/lang/String;)Lcom/tencent/aio/data/AIOParam$a;", "factoryName", "e", "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, h.F, "", "enterExtPanel", "d", "Landroid/os/Bundle;", "bundle", "a", "", "cacheable", "i", WadlProxyConsts.PARAM_IS_PRELOAD, "j", "firstScreenHelperName", "g", "Lts/b;", "aioService", "b", "Lcom/tencent/aio/data/AIOParam;", "c", "Lcom/tencent/aio/data/AIOParam;", "param", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final AIOParam param;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                this.param = new AIOParam();
            }
        }

        @NotNull
        public final a a(@NotNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            }
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.param.mExtBundle.putAll(bundle);
            return this;
        }

        @NotNull
        public final a b(@Nullable b aioService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) aioService);
            }
            this.param.t(aioService);
            return this;
        }

        @NotNull
        public final AIOParam c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (AIOParam) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.param;
        }

        @NotNull
        public final a d(int enterExtPanel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.param.mEnterExtPanel = enterExtPanel;
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, enterExtPanel);
        }

        @NotNull
        public final a e(@NotNull String factoryName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) factoryName);
            }
            Intrinsics.checkNotNullParameter(factoryName, "factoryName");
            this.param.mFactoryNames.add(factoryName);
            return this;
        }

        @NotNull
        public final a f(@NotNull String... factoryNames) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) factoryNames);
            }
            Intrinsics.checkNotNullParameter(factoryNames, "factoryNames");
            CollectionsKt__MutableCollectionsKt.addAll(this.param.mFactoryNames, factoryNames);
            return this;
        }

        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "aioAssistanceService", imports = {}))
        @NotNull
        public final a g(@NotNull String firstScreenHelperName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) firstScreenHelperName);
            }
            Intrinsics.checkNotNullParameter(firstScreenHelperName, "firstScreenHelperName");
            this.param.mFirstScreenHelperName = firstScreenHelperName;
            return this;
        }

        @NotNull
        public final a h(@NotNull AIOSession session) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) session);
            }
            Intrinsics.checkNotNullParameter(session, "session");
            this.param.mSession = new AIOSession(session.c());
            return this;
        }

        @NotNull
        public final a i(boolean cacheable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.param.mCacheable = cacheable;
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 6, (Object) this, cacheable);
        }

        @NotNull
        public final a j(boolean isPreLoad) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.param.mIsPreLoad = isPreLoad;
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, isPreLoad);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/data/AIOParam$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/aio/data/AIOParam;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/aio/data/AIOParam;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.data.AIOParam$b, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion implements Parcelable.Creator<AIOParam> {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AIOParam createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (AIOParam) iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AIOParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AIOParam[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOParam[]) iPatchRedirector.redirect((short) 2, (Object) this, size);
            }
            return new AIOParam[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mExtBundle = new Bundle();
            this.mFactoryNames = new ArrayList();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mCacheable;
    }

    @NotNull
    public final Bundle l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mExtBundle;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mEnterExtPanel;
    }

    @NotNull
    public final String n() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.mFactoryNames);
            return (String) first;
        }
        return (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @NotNull
    public final List<String> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mFactoryNames;
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "AIOContext.getAssistanceService(", imports = {}))
    @Nullable
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mFirstScreenHelperName;
    }

    @Nullable
    public final b q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mAIOAssistanceService;
    }

    @NotNull
    public final AIOSession r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOSession) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AIOSession aIOSession = this.mSession;
        Intrinsics.checkNotNull(aIOSession);
        return aIOSession;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mIsPreLoad;
    }

    public final void t(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.mAIOAssistanceService = bVar;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.mSession, flags);
        parcel.writeInt(this.mEnterExtPanel);
        parcel.writeBundle(this.mExtBundle);
        parcel.writeByte(this.mCacheable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCacheKey);
        parcel.writeByte(this.mIsPreLoad ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mFirstScreenHelperName);
        parcel.writeStringList(this.mFactoryNames);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIOParam(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
            return;
        }
        this.mSession = (AIOSession) parcel.readParcelable(AIOSession.class.getClassLoader());
        this.mEnterExtPanel = parcel.readInt();
        this.mExtBundle.putAll(parcel.readBundle(AIOSession.class.getClassLoader()));
        byte b16 = (byte) 0;
        this.mCacheable = parcel.readByte() != b16;
        this.mCacheKey = parcel.readString();
        this.mIsPreLoad = parcel.readByte() != b16;
        this.mFirstScreenHelperName = parcel.readString();
        parcel.readStringList(this.mFactoryNames);
    }
}
