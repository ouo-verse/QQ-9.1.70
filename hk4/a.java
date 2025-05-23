package hk4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import pl4.c;
import pl4.d;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloTeamOuterClass$GuildLiveRoomJoinCondition;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamEnterConditionRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* compiled from: P */
    /* renamed from: hk4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10447a implements d<YoloTeamOuterClass$YoloTeamEnterConditionRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f405215a;

        C10447a(IResultListener iResultListener) {
            this.f405215a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloTeamOuterClass$YoloTeamEnterConditionRsp yoloTeamOuterClass$YoloTeamEnterConditionRsp, @Nullable FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f405215a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
            l.e("TeamEnterConditionRequest", "TeamEnterConditionRequest failed : errorCode == " + i16 + ", errorMessage == " + str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloTeamOuterClass$YoloTeamEnterConditionRsp yoloTeamOuterClass$YoloTeamEnterConditionRsp, FromServiceMsg fromServiceMsg) {
            if (yoloTeamOuterClass$YoloTeamEnterConditionRsp != null) {
                IResultListener iResultListener = this.f405215a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(yoloTeamOuterClass$YoloTeamEnterConditionRsp);
                }
                l.i("TeamEnterConditionRequest", "TeamEnterConditionRequest success : " + yoloTeamOuterClass$YoloTeamEnterConditionRsp.schema.get());
                return;
            }
            IResultListener iResultListener2 = this.f405215a;
            if (iResultListener2 != null) {
                iResultListener2.onError(-1, "response is null");
            }
            l.e("TeamEnterConditionRequest", "TeamEnterConditionRequest failed : response is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public YoloRoomOuterClass$QQLiveRoomConfig f405216a;

        /* renamed from: b, reason: collision with root package name */
        public YoloTeamOuterClass$GuildLiveRoomJoinCondition f405217b;

        /* renamed from: c, reason: collision with root package name */
        public int f405218c;

        /* renamed from: d, reason: collision with root package name */
        public String f405219d;

        /* renamed from: e, reason: collision with root package name */
        public String f405220e;

        /* renamed from: f, reason: collision with root package name */
        public int f405221f;

        /* renamed from: g, reason: collision with root package name */
        public int f405222g;
    }

    public static void a(b bVar, IResultListener<YoloTeamOuterClass$YoloTeamEnterConditionRsp> iResultListener) {
        ((c) mm4.b.b(c.class)).F1(ik4.a.d(bVar), YoloTeamOuterClass$YoloTeamEnterConditionRsp.class, new C10447a(iResultListener));
    }
}
