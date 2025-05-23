package f61;

import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import java.util.ArrayList;
import tencent.im.mutualmark.mutualmark$Button;
import tencent.im.mutualmark.mutualmark$Graded;
import tencent.im.mutualmark.mutualmark$State;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {
    public static MutualMarkModel a(mutualmark$State mutualmark_state) {
        boolean z16;
        MutualMarkModel mutualMarkModel = new MutualMarkModel();
        if (mutualmark_state == null) {
            return mutualMarkModel;
        }
        if (mutualmark_state.status.dst_uin.has()) {
            mutualMarkModel.C = mutualmark_state.status.dst_uin.get();
        }
        if (mutualmark_state.info.f435957id.has()) {
            mutualMarkModel.D = mutualmark_state.info.f435957id.get();
        }
        if (mutualmark_state.info.category.has()) {
            mutualMarkModel.F = mutualmark_state.info.category.get();
        }
        if (mutualmark_state.info.rarity.has()) {
            mutualMarkModel.G = mutualmark_state.info.rarity.get();
        }
        if (mutualmark_state.info.icon_format.has()) {
            mutualMarkModel.U = mutualmark_state.info.icon_format.get();
        }
        if (mutualmark_state.status.lightup_days.has()) {
            mutualMarkModel.V = mutualmark_state.status.lightup_days.get();
        }
        if (mutualmark_state.status.lightup_time.has()) {
            mutualMarkModel.W = mutualmark_state.status.lightup_time.get();
        }
        if (mutualmark_state.info.flag.has()) {
            mutualMarkModel.X = mutualmark_state.info.flag.get();
        }
        if (mutualmark_state.status.action.has()) {
            mutualMarkModel.Z = new ArrayList();
            for (mutualmark$Button mutualmark_button : mutualmark_state.status.action.get()) {
                MutualMarkModel.Button button = new MutualMarkModel.Button();
                button.f252162d = mutualmark_button.name.get();
                button.f252163e = mutualmark_button.text.get();
                button.f252164f = mutualmark_button.url.get();
                if (mutualmark_button.hide.has() && mutualmark_button.hide.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                button.f252166i = z16;
                button.f252165h = mutualmark_button.react_button_name.get();
                button.f252167m = mutualmark_button.style.get();
                mutualMarkModel.Z.add(button);
            }
        }
        if (mutualmark_state.info.graded.has()) {
            mutualMarkModel.Y = new ArrayList();
            for (mutualmark$Graded mutualmark_graded : mutualmark_state.info.graded.get()) {
                MutualMarkModel.Graded graded = new MutualMarkModel.Graded();
                graded.f252168d = (int) mutualmark_graded.level.get();
                graded.f252169e = mutualmark_graded.name.get();
                graded.f252170f = mutualmark_graded.threshold.get();
                graded.f252171h = mutualmark_graded.desc.get();
                mutualMarkModel.Y.add(graded);
                b(mutualMarkModel, mutualmark_state.status.level.get(), mutualmark_graded.level.get(), mutualmark_graded.name.get());
            }
        }
        if (mutualmark_state.status.level.has()) {
            mutualMarkModel.H = mutualmark_state.status.level.get();
        }
        if (mutualmark_state.status.sub_level.has()) {
            mutualMarkModel.I = mutualmark_state.status.sub_level.get();
        }
        if (mutualmark_state.status.group_lightup_count.has()) {
            mutualMarkModel.J = mutualmark_state.status.group_lightup_count.get();
        }
        if (mutualmark_state.status.group_total.has()) {
            mutualMarkModel.K = mutualmark_state.status.group_total.get();
        }
        if (mutualmark_state.status.count.has()) {
            mutualMarkModel.L = mutualmark_state.status.count.get();
        }
        if (mutualmark_state.status.is_wearing.has()) {
            mutualMarkModel.M = mutualmark_state.status.is_wearing.get();
        }
        if (mutualmark_state.status.is_lightup.has()) {
            mutualMarkModel.N = mutualmark_state.status.is_lightup.get();
        }
        if (mutualmark_state.status.is_degrade.has()) {
            mutualMarkModel.P = mutualmark_state.status.is_degrade.get();
        }
        if (mutualmark_state.status.is_prefetch.has()) {
            mutualMarkModel.Q = mutualmark_state.status.is_prefetch.get();
        }
        if (mutualmark_state.status.is_lightoff.has()) {
            mutualMarkModel.R = mutualmark_state.status.is_lightoff.get();
        }
        if (mutualmark_state.status.is_once.has()) {
            mutualMarkModel.T = mutualmark_state.status.is_once.get();
        }
        if (mutualmark_state.status.is_new.has()) {
            mutualMarkModel.S = mutualmark_state.status.is_new.get();
        }
        mutualMarkModel.f252159h = mutualmark_state.status.icon_url.get();
        if (mutualmark_state.status.extend_name.has()) {
            mutualMarkModel.f252155a0 = mutualmark_state.status.extend_name.get();
        }
        if (mutualMarkModel.G > 0) {
            mutualMarkModel.f252160i = "https://downv6.qq.com/extendfriend/mutual_tag_xiyou.png";
        } else if (mutualMarkModel.F == 3) {
            mutualMarkModel.f252160i = "https://downv6.qq.com/extendfriend/mutual_tag_xianding.png";
        } else {
            mutualMarkModel.f252160i = "";
        }
        if (mutualMarkModel.M) {
            mutualMarkModel.f252161m = "https://downv6.qq.com/extendfriend/mutual_tag_peidai.png";
        } else if (mutualMarkModel.S) {
            mutualMarkModel.f252161m = "https://downv6.qq.com/extendfriend/mutual_tag_new.png";
        } else {
            mutualMarkModel.f252161m = "";
        }
        return mutualMarkModel;
    }

    public static void b(MutualMarkModel mutualMarkModel, long j3, long j16, String str) {
        if (j3 == j16) {
            mutualMarkModel.E = str;
            return;
        }
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        if (!IntimateHeaderCardUtil.O((int) mutualMarkModel.D) && j3 == 0 && j16 == 1) {
            mutualMarkModel.E = str;
        }
    }
}
