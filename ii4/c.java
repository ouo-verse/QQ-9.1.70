package ii4;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.timi.game.jump.api.impl.TgSchemeParserUtil;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends ax {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        this.f307439d = "qqlive";
        this.f307440e = "startlive";
    }

    private boolean F(Context context, HashMap<String, String> hashMap) {
        l.h("TgQQLiveStartLiveAction", 1, "handleAction attrs: " + hashMap);
        TgSchemeParserUtil.m(context, hashMap, "TgQQLiveStartLiveAction", new a(hashMap, context));
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        return F(this.f307437b, this.f307441f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements nf4.a<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f407720a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f407721b;

        a(HashMap hashMap, Context context) {
            this.f407720a = hashMap;
            this.f407721b = context;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            String str = (String) this.f407720a.get("game_openid");
            boolean equals = "true".equals(this.f407720a.get("from_onekey"));
            int j3 = TgSchemeParserUtil.j((String) this.f407720a.get("room_type"), 1);
            int j16 = TgSchemeParserUtil.j((String) this.f407720a.get(RoomServiceConstants.PARAMS_GAME_ID), 0);
            String str2 = (String) this.f407720a.get("taskid");
            Intent intent = new Intent();
            intent.putExtra("game_openid", str);
            intent.putExtra("from_onekey", equals);
            intent.putExtra(RoomServiceConstants.PARAMS_GAME_ID, j16);
            intent.putExtra("room_type", j3);
            intent.putExtra("taskid", str2);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(this.f407721b, intent);
        }

        @Override // nf4.a
        public void onError(int i3, String str) {
        }
    }
}
