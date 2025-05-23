package hk4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import pl4.c;
import pl4.d;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamJoinBattleRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements d<YoloTeamOuterClass$YoloTeamJoinBattleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f405223a;

        a(IResultListener iResultListener) {
            this.f405223a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloTeamOuterClass$YoloTeamJoinBattleRsp yoloTeamOuterClass$YoloTeamJoinBattleRsp, @Nullable FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f405223a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
            l.e("TeamJoinBattleRequest", "TeamJoinBattleRequest failed : errorCode == " + i16 + ", errorMessage == " + str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloTeamOuterClass$YoloTeamJoinBattleRsp yoloTeamOuterClass$YoloTeamJoinBattleRsp, FromServiceMsg fromServiceMsg) {
            if (yoloTeamOuterClass$YoloTeamJoinBattleRsp != null) {
                IResultListener iResultListener = this.f405223a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(yoloTeamOuterClass$YoloTeamJoinBattleRsp);
                }
                l.i("TeamJoinBattleRequest", "TeamJoinBattleRequest success : teamId == " + yoloTeamOuterClass$YoloTeamJoinBattleRsp.team_info.team_id);
                return;
            }
            IResultListener iResultListener2 = this.f405223a;
            if (iResultListener2 != null) {
                iResultListener2.onError(-1, "response is null");
            }
            l.e("TeamJoinBattleRequest", "TeamJoinBattleRequest failed : response is null");
        }
    }

    /* compiled from: P */
    /* renamed from: hk4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C10448b {

        /* renamed from: a, reason: collision with root package name */
        public long f405224a;

        /* renamed from: b, reason: collision with root package name */
        public int f405225b;

        /* renamed from: c, reason: collision with root package name */
        public int f405226c;

        /* renamed from: d, reason: collision with root package name */
        public String f405227d;

        /* renamed from: e, reason: collision with root package name */
        public String f405228e;

        /* renamed from: f, reason: collision with root package name */
        public int f405229f;
    }

    public static void a(C10448b c10448b, IResultListener<YoloTeamOuterClass$YoloTeamJoinBattleRsp> iResultListener) {
        ((c) mm4.b.b(c.class)).F1(ik4.b.d(c10448b.f405224a, c10448b.f405225b, c10448b.f405226c, c10448b.f405228e, c10448b.f405227d, c10448b.f405229f), YoloTeamOuterClass$YoloTeamJoinBattleRsp.class, new a(iResultListener));
    }
}
