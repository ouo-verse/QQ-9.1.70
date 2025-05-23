package p42;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.remote.ServiceConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f425326a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static Intent a(@NonNull xt0.a aVar) {
        String account;
        String str;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(aVar.f448496f);
        intent.putExtra("source", valueOf);
        bundle.putString("source", valueOf);
        f425326a.i("ICGameEntrance|EnterRoomUtil", "enterRoom source:" + valueOf);
        long longValue = c(aVar.f448493c).longValue();
        intent.putExtra("roomid", longValue);
        f425326a.i("ICGameEntrance|EnterRoomUtil", "enterRoom roomId:" + longValue);
        String str2 = aVar.f448500j;
        f425326a.i("ICGameEntrance|EnterRoomUtil", "enterRoom roomType:" + str2);
        bundle.putInt("ext_enter_room_room_type", b(str2).intValue());
        String str3 = aVar.f448503m;
        if (str3 == null) {
            str3 = String.valueOf(0L);
        }
        bundle.putLong("ext_enter_room_video_source_app_id", c(str3).longValue());
        String str4 = aVar.f448501k;
        f425326a.i("ICGameEntrance|EnterRoomUtil", "enterRoom gameId:" + str4);
        bundle.putInt("ext_enter_room_game_id", b(str4).intValue());
        String str5 = aVar.f448502l;
        f425326a.i("ICGameEntrance|EnterRoomUtil", "enterRoom gameTagId:" + str5);
        bundle.putInt("ext_enter_room_game_tag_id", b(str5).intValue());
        bundle.putString("coverurl", aVar.f448494d);
        bundle.putString("trace_info", aVar.f448497g);
        bundle.putLong(AEEditorConstants.VIDEO_CLIP_START_TIME, c(aVar.f448505o).longValue());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            account = "";
        } else {
            account = peekAppRuntime.getAccount();
        }
        bundle.putString(ServiceConst.PARA_SESSION_ID, account + "_" + System.currentTimeMillis());
        if (QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
            str = "1";
        } else {
            str = "0";
        }
        bundle.putString("tool_state", str);
        bundle.putString("rcmd_context", aVar.f448504n);
        bundle.putString("jump_start_time", aVar.f448505o);
        bundle.putString("traceId", aVar.f448508r);
        bundle.putString("scene_id", aVar.f448509s);
        bundle.putString("qz_gdt", aVar.f448510t);
        bundle.putString("mqqschema", aVar.f448511u);
        intent.putExtra("biz_ext_data", bundle);
        return intent;
    }

    public static Integer b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e16) {
            f425326a.e("ICGameEntrance|EnterRoomUtil", "safeParseInt fail ", e16);
            return 0;
        }
    }

    public static Long c(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e16) {
            f425326a.e("ICGameEntrance|EnterRoomUtil", "safeParseLong fail ", e16);
            return 0L;
        }
    }
}
