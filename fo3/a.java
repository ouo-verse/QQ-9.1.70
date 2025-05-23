package fo3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.api.ITimiGameApi;
import hn3.LinkScreenAnchorInfo;
import java.util.HashMap;
import kl4.k;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private k f400174a;

    /* renamed from: b, reason: collision with root package name */
    private IAegisLogApi f400175b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    private Context f400176c;

    /* renamed from: d, reason: collision with root package name */
    private LinkScreenAnchorInfo f400177d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f400178e;

    /* renamed from: f, reason: collision with root package name */
    private String f400179f;

    /* compiled from: P */
    /* renamed from: fo3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class DialogInterfaceOnClickListenerC10329a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC10329a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            a aVar = a.this;
            aVar.e(aVar.f400176c, a.this.f400178e, a.this.f400179f);
        }
    }

    public a(Context context, LinkScreenAnchorInfo linkScreenAnchorInfo, Bundle bundle, String str) {
        this.f400176c = context;
        this.f400177d = linkScreenAnchorInfo;
        this.f400178e = bundle;
        this.f400179f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, Bundle bundle, String str) {
        if (this.f400177d == null) {
            return;
        }
        if (bundle == null) {
            this.f400175b.w("PkAnchorRoomJumper", 1, "illegal state, end start room");
            return;
        }
        this.f400175b.i("PkAnchorRoomJumper", 1, "\u5f00\u59cb pk\u8fdb\u5165\u5bf9\u65b9\u623f\u95f4");
        long roomId = this.f400177d.getRoomId();
        String format = String.format("mqqapi://vaslive/watch?roomid=%s&room_type=%s&video_source=%s&qq_live_product_type=%s&pip=%s&translucent_page=%s&from=%s&noclearTop=0", Long.valueOf(roomId), Integer.valueOf(bundle.getInt("ext_enter_room_room_type", 0)), Long.valueOf(bundle.getLong("ext_enter_room_video_source_app_id")), bundle.getString(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE), bundle.getString("pip"), Boolean.valueOf(bundle.getBoolean("translucent_page")), str);
        this.f400175b.i("PkAnchorRoomJumper", 1, "doEnterRoom: " + format);
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(format));
        context.startActivity(intent);
        g("clck", String.valueOf(roomId));
    }

    private void g(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_qqlive_inf_jumproom");
        hashMap.put("qqlive_to_room_id", str2);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(str, hashMap);
    }

    public void f() {
        if (this.f400176c == null) {
            return;
        }
        k c06 = new k(this.f400176c).b0(this.f400176c.getString(R.string.zrp)).f0(this.f400176c.getString(R.string.a8j)).e0(new DialogInterfaceOnClickListenerC10329a()).d0(this.f400176c.getString(R.string.cancel)).c0(new b());
        this.f400174a = c06;
        c06.setCanceledOnTouchOutside(true);
        this.f400174a.show();
    }

    public void h() {
        k kVar = this.f400174a;
        if (kVar != null) {
            kVar.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
