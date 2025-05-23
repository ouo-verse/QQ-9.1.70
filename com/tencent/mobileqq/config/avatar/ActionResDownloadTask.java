package com.tencent.mobileqq.config.avatar;

import com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mActionResCallback$2;
import com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mBaseResCallback$2;
import com.tencent.mobileqq.config.avatar.download.ResFile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\b*\u0002'+\u0018\u0000 12\u00020\u0001:\u0001\u000eB#\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J5\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010$R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b \u0010)R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b\u0015\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/ActionResDownloadTask;", "", "", "i", "Lcom/tencent/mobileqq/config/avatar/download/d;", "baseResFile", "", "baseResLoaded", "actionResFile", "actionResLoaded", tl.h.F, "(Lcom/tencent/mobileqq/config/avatar/download/d;Ljava/lang/Boolean;Lcom/tencent/mobileqq/config/avatar/download/d;Ljava/lang/Boolean;)V", "g", "", "a", "I", DetailMeFragmentConfig.CURRENT_STATUS_ID, "Lcom/tencent/mobileqq/config/avatar/a;", "b", "Lcom/tencent/mobileqq/config/avatar/a;", "mListener", "c", "subIndex", "Lcom/tencent/mobileqq/config/avatar/i;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/config/avatar/i;", "mAvatarConfigItem", "Lcom/tencent/mobileqq/config/avatar/h;", "e", "()Lcom/tencent/mobileqq/config/avatar/h;", "mBaseConfig", "f", "Z", "mBaseResLoaded", "mActionResLoaded", "Lcom/tencent/mobileqq/config/avatar/download/d;", "mBaseResLoadedFile", "mActionResLoadedFile", "com/tencent/mobileqq/config/avatar/ActionResDownloadTask$mBaseResCallback$2$a", "j", "()Lcom/tencent/mobileqq/config/avatar/ActionResDownloadTask$mBaseResCallback$2$a;", "mBaseResCallback", "com/tencent/mobileqq/config/avatar/ActionResDownloadTask$mActionResCallback$2$a", "k", "()Lcom/tencent/mobileqq/config/avatar/ActionResDownloadTask$mActionResCallback$2$a;", "mActionResCallback", "<init>", "(ILcom/tencent/mobileqq/config/avatar/a;I)V", "l", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ActionResDownloadTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int statusId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a mListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int subIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAvatarConfigItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBaseConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mBaseResLoaded;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mActionResLoaded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ResFile mBaseResLoadedFile;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ResFile mActionResLoadedFile;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBaseResCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mActionResCallback;

    public ActionResDownloadTask(int i3, @Nullable a aVar, int i16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        this.statusId = i3;
        this.mListener = aVar;
        this.subIndex = i16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConfigData>() { // from class: com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mAvatarConfigItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ConfigData invoke() {
                int i17;
                int i18;
                AvatarViewConfig a16 = AvatarViewConfig.INSTANCE.a();
                i17 = ActionResDownloadTask.this.statusId;
                i18 = ActionResDownloadTask.this.subIndex;
                return a16.f(i17, i18);
            }
        });
        this.mAvatarConfigItem = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BaseConfigItem>() { // from class: com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mBaseConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BaseConfigItem invoke() {
                return AvatarViewConfig.INSTANCE.a().g();
            }
        });
        this.mBaseConfig = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ActionResDownloadTask$mBaseResCallback$2.a>() { // from class: com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mBaseResCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/avatar/ActionResDownloadTask$mBaseResCallback$2$a", "Lcom/tencent/mobileqq/config/avatar/download/a;", "Lcom/tencent/mobileqq/config/avatar/download/d;", "file", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes10.dex */
            public static final class a implements com.tencent.mobileqq.config.avatar.download.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ActionResDownloadTask f202355a;

                a(ActionResDownloadTask actionResDownloadTask) {
                    this.f202355a = actionResDownloadTask;
                }

                @Override // com.tencent.mobileqq.config.avatar.download.a
                public void a(@Nullable ResFile file) {
                    QLog.i("AvatarResDownloadTask", 1, "base onDownComplete " + file);
                    this.f202355a.h(file, Boolean.TRUE, null, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(ActionResDownloadTask.this);
            }
        });
        this.mBaseResCallback = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ActionResDownloadTask$mActionResCallback$2.a>() { // from class: com.tencent.mobileqq.config.avatar.ActionResDownloadTask$mActionResCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/avatar/ActionResDownloadTask$mActionResCallback$2$a", "Lcom/tencent/mobileqq/config/avatar/download/a;", "Lcom/tencent/mobileqq/config/avatar/download/d;", "file", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes10.dex */
            public static final class a implements com.tencent.mobileqq.config.avatar.download.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ActionResDownloadTask f202354a;

                a(ActionResDownloadTask actionResDownloadTask) {
                    this.f202354a = actionResDownloadTask;
                }

                @Override // com.tencent.mobileqq.config.avatar.download.a
                public void a(@Nullable ResFile file) {
                    QLog.i("AvatarResDownloadTask", 1, "action onDownComplete " + file);
                    this.f202354a.h(null, null, file, Boolean.TRUE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(ActionResDownloadTask.this);
            }
        });
        this.mActionResCallback = lazy4;
    }

    private final ActionResDownloadTask$mActionResCallback$2.a c() {
        return (ActionResDownloadTask$mActionResCallback$2.a) this.mActionResCallback.getValue();
    }

    private final ConfigData d() {
        return (ConfigData) this.mAvatarConfigItem.getValue();
    }

    private final BaseConfigItem e() {
        return (BaseConfigItem) this.mBaseConfig.getValue();
    }

    private final ActionResDownloadTask$mBaseResCallback$2.a f() {
        return (ActionResDownloadTask$mBaseResCallback$2.a) this.mBaseResCallback.getValue();
    }

    public final void g() {
        if (this.mBaseResLoaded && this.mActionResLoaded) {
            if (this.mActionResLoadedFile != null && this.mBaseResLoadedFile != null) {
                a aVar = this.mListener;
                if (aVar != null) {
                    ResFile resFile = this.mBaseResLoadedFile;
                    Intrinsics.checkNotNull(resFile);
                    String filePath = resFile.getFilePath();
                    ResFile resFile2 = this.mActionResLoadedFile;
                    Intrinsics.checkNotNull(resFile2);
                    String filePath2 = resFile2.getFilePath();
                    ResFile resFile3 = this.mBaseResLoadedFile;
                    Intrinsics.checkNotNull(resFile3);
                    String md5 = resFile3.getMD5();
                    ResFile resFile4 = this.mActionResLoadedFile;
                    Intrinsics.checkNotNull(resFile4);
                    aVar.a(new com.tencent.mobileqq.onlinestatus.model.b(filePath, filePath2, new com.tencent.mobileqq.onlinestatus.model.a(md5, resFile4.getMD5())));
                    return;
                }
                return;
            }
            QLog.i("AvatarResDownloadTask", 1, "base Path is " + this.mBaseResLoadedFile);
            QLog.i("AvatarResDownloadTask", 1, "action path is " + this.mActionResLoadedFile);
            a aVar2 = this.mListener;
            if (aVar2 != null) {
                aVar2.a(null);
                return;
            }
            return;
        }
        QLog.i("AvatarResDownloadTask", 1, "res not loaded, wait next notify");
    }

    public final synchronized void h(@Nullable ResFile baseResFile, @Nullable Boolean baseResLoaded, @Nullable ResFile actionResFile, @Nullable Boolean actionResLoaded) {
        if (baseResFile != null) {
            try {
                this.mBaseResLoadedFile = baseResFile;
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (baseResLoaded != null) {
            this.mBaseResLoaded = baseResLoaded.booleanValue();
        }
        if (actionResFile != null) {
            this.mActionResLoadedFile = actionResFile;
        }
        if (actionResLoaded != null) {
            this.mActionResLoaded = actionResLoaded.booleanValue();
        }
        g();
    }

    public final void i() {
        if (d() != null && e() != null) {
            String h16 = d.f202369a.h();
            BaseConfigItem e16 = e();
            Intrinsics.checkNotNull(e16);
            String actionResUrl = e16.getActionResUrl();
            BaseConfigItem e17 = e();
            Intrinsics.checkNotNull(e17);
            String actionResUrlMd5 = e17.getActionResUrlMd5();
            String str = File.separator;
            String str2 = h16 + str + actionResUrlMd5;
            new com.tencent.mobileqq.config.avatar.download.c(actionResUrl, str2, str2 + "_zip", actionResUrlMd5, f()).e();
            ConfigData d16 = d();
            Intrinsics.checkNotNull(d16);
            String actionResUrl2 = d16.getActionResUrl();
            ConfigData d17 = d();
            Intrinsics.checkNotNull(d17);
            String actionResUrlMd52 = d17.getActionResUrlMd5();
            ConfigData d18 = d();
            Intrinsics.checkNotNull(d18);
            String str3 = h16 + str + d18.getActionId() + str + actionResUrlMd52;
            new com.tencent.mobileqq.config.avatar.download.c(actionResUrl2, str3, str3 + "_zip", actionResUrlMd52, c()).e();
            return;
        }
        QLog.i("AvatarResDownloadTask", 1, "no config for status id, id=" + this.statusId);
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(null);
        }
    }
}
