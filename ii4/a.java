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
public class a extends ax {
    /* JADX INFO: Access modifiers changed from: protected */
    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        this.f307439d = "qqlive";
        this.f307440e = "main";
    }

    private boolean F(Context context, HashMap<String, String> hashMap) {
        l.h("TgQQLiveOpenAnchorMainAction", 1, "handleAction attrs: " + hashMap);
        TgSchemeParserUtil.m(context, hashMap, "TgQQLiveOpenAnchorMainAction", new C10531a(hashMap, context));
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        return F(this.f307437b, this.f307441f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ii4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10531a implements nf4.a<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f407717a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f407718b;

        C10531a(HashMap hashMap, Context context) {
            this.f407717a = hashMap;
            this.f407718b = context;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            String str = (String) this.f407717a.get("game_openid");
            boolean equals = "true".equals(this.f407717a.get("from_onekey"));
            int j3 = TgSchemeParserUtil.j((String) this.f407717a.get(RoomServiceConstants.PARAMS_GAME_ID), 0);
            String str2 = (String) this.f407717a.get("jumpcmd");
            if (equals) {
                long c16 = ((ni4.a) mm4.b.b(ni4.a.class)).b0().c();
                l.h("TgQQLiveOpenAnchorMainAction", 1, "handleAction- isOneKeyLive - " + c16);
                if (c16 != 0) {
                    ((ni4.a) mm4.b.b(ni4.a.class)).X2(this.f407718b, c16, str2);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("game_openid", str);
                intent.putExtra("from_onekey", equals);
                intent.putExtra(RoomServiceConstants.PARAMS_GAME_ID, j3);
                intent.putExtra("jumpcmd", str2);
                intent.putExtra("room_type", 1);
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(this.f407718b, intent);
                return;
            }
            ((ni4.a) mm4.b.b(ni4.a.class)).openAnchorRoomPage(this.f407718b, 4, str2);
        }

        @Override // nf4.a
        public void onError(int i3, String str) {
        }
    }
}
