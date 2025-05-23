package is1;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import i02.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or1.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lis1/e;", "Lef1/b;", "", "U1", "", "Q1", "T1", "onCleared", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "", "guildId", "S1", "R1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Lcom/tencent/mobileqq/guild/util/cn;", "D", "Lcom/tencent/mobileqq/guild/util/cn;", "O1", "()Lcom/tencent/mobileqq/guild/util/cn;", "showRedPointLiveDate", "E", "Ljava/lang/String;", "Lor1/c$a;", UserInfo.SEX_FEMALE, "Lor1/c$a;", "updateRedPointListener", "Lwu1/b;", "G", "Lwu1/b;", "guildSettingMissionObserver", "Li02/a$a;", "H", "Li02/a$a;", "nativeRedPointListener", "<init>", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private GuildFacadeType facadeType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> showRedPointLiveDate;

    /* renamed from: E, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final c.a updateRedPointListener;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final wu1.b guildSettingMissionObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a.InterfaceC10498a nativeRedPointListener;

    public e(@NotNull GuildFacadeType facadeType) {
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        this.facadeType = facadeType;
        this.showRedPointLiveDate = new cn<>();
        c.a aVar = new c.a() { // from class: is1.b
        };
        this.updateRedPointListener = aVar;
        wu1.b bVar = new wu1.b() { // from class: is1.c
            @Override // wu1.b
            public final void a() {
                e.P1(e.this);
            }
        };
        this.guildSettingMissionObserver = bVar;
        a.InterfaceC10498a interfaceC10498a = new a.InterfaceC10498a() { // from class: is1.d
        };
        this.nativeRedPointListener = interfaceC10498a;
        or1.c.b(aVar);
        wu1.a.f446537c.e(bVar);
        i02.a.a(interfaceC10498a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U1();
    }

    private final boolean Q1() {
        return i02.a.b();
    }

    private final boolean T1() {
        String str;
        if (this.facadeType != GuildFacadeType.Tab || (str = this.guildId) == null) {
            return false;
        }
        wu1.a aVar = wu1.a.f446537c;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        if (!aVar.b(str)) {
            return false;
        }
        String str3 = this.guildId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
        } else {
            str2 = str3;
        }
        return !aVar.c(str2, "enter_setting");
    }

    private final void U1() {
        if (!T1() && !this.facadeType.isPreviewStyle()) {
            if (this.guildId != null && Q1()) {
                this.showRedPointLiveDate.postValue(Boolean.TRUE);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.MF.Rt.GuildFacadeTopFrameViewModel", 2, "updateRedPointState " + O1().getValue());
                    return;
                }
                return;
            }
            return;
        }
        this.showRedPointLiveDate.postValue(Boolean.FALSE);
    }

    @NotNull
    public final cn<Boolean> O1() {
        return this.showRedPointLiveDate;
    }

    public final void R1() {
        U1();
    }

    public final void S1(@NotNull GuildFacadeType facadeType, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.facadeType = facadeType;
        this.guildId = guildId;
        U1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        or1.c.d(this.updateRedPointListener);
        wu1.a.f446537c.f(this.guildSettingMissionObserver);
        i02.a.c(this.nativeRedPointListener);
    }
}
