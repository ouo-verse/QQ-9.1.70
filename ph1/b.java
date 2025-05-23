package ph1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout;
import com.tencent.mobileqq.guild.discovery.widget.voiceavatar.MineVoicingAvatarView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import fh1.AvatarInfo;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\u0004\b!\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lph1/b;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$d;", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoicingAvatarView;", "Lfh1/a;", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", "data", "", "l", DomainData.DOMAIN_NAME, "p", "", "voicingInfos", "audienceInfos", "j", "", "f", UserInfo.SEX_FEMALE, "getSizeRatio", "()F", "r", "(F)V", "sizeRatio", "", "g", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "guildId", "<init>", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends GuildVoicingAvatarLayout.d<MineVoicingAvatarView, AvatarInfo> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float sizeRatio;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    public b(float f16) {
        this.sizeRatio = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MineVoicingAvatarView view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.d();
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
    public void j(@NotNull List<AvatarInfo> voicingInfos, @NotNull List<AvatarInfo> audienceInfos) {
        Intrinsics.checkNotNullParameter(voicingInfos, "voicingInfos");
        Intrinsics.checkNotNullParameter(audienceInfos, "audienceInfos");
        super.j(voicingInfos, audienceInfos);
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull MineVoicingAvatarView view, @NotNull AvatarInfo data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MineVoicingAvatarAdapter", 2, "onBindView view:" + view.hashCode() + ", data:" + data);
        }
        view.e(data, this.guildId);
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public MineVoicingAvatarView g(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        MineVoicingAvatarView mineVoicingAvatarView = new MineVoicingAvatarView(context, null, 2, null);
        int d16 = (int) (((int) cw.d(37)) * this.sizeRatio);
        mineVoicingAvatarView.setLayoutParams(new ViewGroup.LayoutParams(d16, d16));
        mineVoicingAvatarView.getAvatarView().getLayoutParams().height = d16;
        mineVoicingAvatarView.getAvatarView().getLayoutParams().width = d16;
        mineVoicingAvatarView.getAnimationView().getLayoutParams().width = ((int) cw.d(20)) + d16;
        mineVoicingAvatarView.getAnimationView().getLayoutParams().height = ((int) cw.d(20)) + d16;
        mineVoicingAvatarView.getAnimationView().setAvatarSize(d16);
        return mineVoicingAvatarView;
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull final MineVoicingAvatarView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MineVoicingAvatarAdapter", 2, "onStartAnimation");
        }
        view.postDelayed(new Runnable() { // from class: ph1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.o(MineVoicingAvatarView.this);
            }
        }, new Random().nextInt(300));
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void i(@NotNull MineVoicingAvatarView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MineVoicingAvatarAdapter", 2, "onStopAnimation");
        }
        view.a();
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void r(float f16) {
        this.sizeRatio = f16;
    }
}
