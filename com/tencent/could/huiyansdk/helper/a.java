package com.tencent.could.huiyansdk.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.base.HuiYanBaseCallBack;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.liveness.FaceQualityState;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements YtSDKKitFramework.IYtSDKKitFrameworkEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f100119a;

    public a(b bVar) {
        this.f100119a = bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01f4: MOVE (r3 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:501), block:B:95:0x01f4 */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027d  */
    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFrameworkEvent(HashMap<String, Object> hashMap) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        k kVar;
        String str;
        String encodeToString;
        HuiYanBaseCallBack huiYanBaseCallBack;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
            return;
        }
        YtLogger.d("YouTuSdkHelper", "hash map: " + hashMap.toString());
        b bVar = this.f100119a;
        bVar.getClass();
        if (hashMap.containsKey(StateEvent.Name.OPERATE_CATCH_ERROR)) {
            String str2 = (String) hashMap.get(StateEvent.Name.OPERATE_CATCH_ERROR);
            if (TextUtils.isEmpty(str2)) {
                k.a.f100197a.a(1, "YouTuSdkHelper", "result str is empty.");
                if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT)) {
                    this.f100119a.getClass();
                    if (!"failed".equals((String) hashMap.get(StateEvent.Name.PROCESS_RESULT))) {
                        k.a.f100197a.a(1, "YouTuSdkHelper", "youtu result is not fail!");
                        return;
                    }
                    HuiYanBaseCallBack huiYanBaseCallBack2 = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack2 == null) {
                        Log.e("YouTuSdkHelper", "deal with action callback is null!");
                        return;
                    }
                    String str3 = (String) hashMap.get("message");
                    Integer num = (Integer) hashMap.get("error_code");
                    if (num != null && num.intValue() == 5242881) {
                        huiYanBaseCallBack2.onFail(285, str3);
                        return;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        huiYanBaseCallBack2.onFail(228, str3);
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    Integer num2 = (Integer) hashMap.get("error_code");
                    sb5.append("{\"errorcode\":");
                    sb5.append(num2);
                    sb5.append("}");
                    huiYanBaseCallBack2.onFail(228, sb5.toString());
                    return;
                }
                if (hashMap.containsKey(StateEvent.Name.UI_TIPS) || hashMap.containsKey(StateEvent.Name.UI_EXTRA_TIPS)) {
                    this.f100119a.getClass();
                    HuiYanBaseCallBack huiYanBaseCallBack3 = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack3 != null) {
                        huiYanBaseCallBack3.onTipEvent(hashMap);
                    }
                }
                boolean z16 = false;
                if (hashMap.containsKey(StateEvent.Name.ACTION_DETECT_TYPE)) {
                    this.f100119a.getClass();
                    Integer num3 = (Integer) hashMap.get(StateEvent.Name.ACTION_DETECT_TYPE);
                    Log.e("YouTuSdkHelper", "actionType: " + num3);
                    HuiYanBaseCallBack huiYanBaseCallBack4 = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack4 == null) {
                        Log.e("YouTuSdkHelper", "deal with action detect callback is null!");
                    } else {
                        huiYanBaseCallBack4.onActionEventChange(num3.intValue(), false, true);
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.BEST_FACE_IMAGE)) {
                    this.f100119a.getClass();
                    FaceQualityState.BestFaceImage bestFaceImage = (FaceQualityState.BestFaceImage) hashMap.get(StateEvent.Name.BEST_FACE_IMAGE);
                    if (bestFaceImage != null && (bArr = bestFaceImage.imageData) != null) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        ByteArrayOutputStream byteArrayOutputStream3 = null;
                        r3 = null;
                        r3 = null;
                        String str4 = null;
                        ByteArrayOutputStream byteArrayOutputStream4 = null;
                        try {
                            if (decodeByteArray != null) {
                                try {
                                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                                } catch (IOException e16) {
                                    e = e16;
                                    byteArrayOutputStream2 = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (byteArrayOutputStream3 != null) {
                                        try {
                                            byteArrayOutputStream3.flush();
                                            byteArrayOutputStream3.close();
                                        } catch (IOException e17) {
                                            k.a.f100197a.a(2, "YouTuSdkHelper", "close IO stream fail: " + e17.getLocalizedMessage());
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                                    byteArrayOutputStream2.flush();
                                    byteArrayOutputStream2.close();
                                    encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                                    byteArrayOutputStream4 = byteArrayOutputStream2;
                                } catch (IOException e18) {
                                    e = e18;
                                    k.a.f100197a.a(2, "YouTuSdkHelper", "bitmap to base64 fail: " + e.getLocalizedMessage());
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.flush();
                                            byteArrayOutputStream2.close();
                                        } catch (IOException e19) {
                                            kVar = k.a.f100197a;
                                            str = "close IO stream fail: " + e19.getLocalizedMessage();
                                            kVar.a(2, "YouTuSdkHelper", str);
                                            if (str4 != null) {
                                            }
                                            huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                                            if (huiYanBaseCallBack != null) {
                                            }
                                            if (hashMap.containsKey(StateEvent.Name.ACTION_DETECT_DONE_TYPE)) {
                                            }
                                            if (hashMap.containsKey(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)) {
                                            }
                                            if (!hashMap.containsKey(StateEvent.Name.UI_ACTION)) {
                                            }
                                        }
                                    }
                                    if (str4 != null) {
                                    }
                                    huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                                    if (huiYanBaseCallBack != null) {
                                    }
                                    if (hashMap.containsKey(StateEvent.Name.ACTION_DETECT_DONE_TYPE)) {
                                    }
                                    if (hashMap.containsKey(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)) {
                                    }
                                    if (!hashMap.containsKey(StateEvent.Name.UI_ACTION)) {
                                    }
                                }
                            } else {
                                encodeToString = null;
                            }
                            if (byteArrayOutputStream4 != null) {
                                try {
                                    byteArrayOutputStream4.flush();
                                    byteArrayOutputStream4.close();
                                } catch (IOException e26) {
                                    kVar = k.a.f100197a;
                                    str4 = encodeToString;
                                    str = "close IO stream fail: " + e26.getLocalizedMessage();
                                    kVar.a(2, "YouTuSdkHelper", str);
                                    if (str4 != null) {
                                    }
                                    huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                                    if (huiYanBaseCallBack != null) {
                                    }
                                    if (hashMap.containsKey(StateEvent.Name.ACTION_DETECT_DONE_TYPE)) {
                                    }
                                    if (hashMap.containsKey(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)) {
                                    }
                                    if (!hashMap.containsKey(StateEvent.Name.UI_ACTION)) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            str4 = encodeToString;
                            if (str4 != null) {
                                k.a.f100197a.a(2, "YouTuSdkHelper", "best image size: " + str4.length());
                            }
                            huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                            if (huiYanBaseCallBack != null) {
                                Log.e("YouTuSdkHelper", "deal with best face image callback is null!");
                            } else {
                                huiYanBaseCallBack.onGetBotBestFaceImage();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                        }
                    } else {
                        Log.e("YouTuSdkHelper", "deal with best face image bestFaceImage is null!");
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.ACTION_DETECT_DONE_TYPE)) {
                    this.f100119a.getClass();
                    Integer num4 = (Integer) hashMap.get(StateEvent.Name.ACTION_DETECT_DONE_TYPE);
                    Integer num5 = (Integer) hashMap.get(StateEvent.Name.ACTION_DETECT_DONE_LAST_COUNT);
                    Log.e("YouTuSdkHelper", "remain actions num: " + num5);
                    HuiYanBaseCallBack huiYanBaseCallBack5 = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack5 == null) {
                        Log.e("YouTuSdkHelper", "deal with action detect done callback is null!");
                    } else {
                        int intValue = num4.intValue();
                        if (num5.intValue() == 0) {
                            z16 = true;
                        }
                        huiYanBaseCallBack5.onActionEventChange(intValue, true, z16);
                        if (num5.intValue() == 0) {
                            huiYanBaseCallBack5.onActionEventChange(6, true, true);
                        }
                    }
                }
                if (hashMap.containsKey(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)) {
                    this.f100119a.getClass();
                    if (hashMap.containsKey(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)) {
                        boolean booleanValue = ((Boolean) hashMap.get(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN)).booleanValue();
                        HuiYanBaseCallBack huiYanBaseCallBack6 = HuiYanBaseApi.b.f100031a.f100028b;
                        if (huiYanBaseCallBack6 == null) {
                            k.a.f100197a.a(2, "YouTuSdkHelper", "send get live error, base call back is null");
                        } else {
                            k.a.f100197a.a(1, "YouTuSdkHelper", "reflection is open: " + booleanValue);
                            huiYanBaseCallBack6.isHaveReflectionMode(booleanValue);
                        }
                    }
                }
                if (!hashMap.containsKey(StateEvent.Name.UI_ACTION) && hashMap.get(StateEvent.Name.UI_ACTION).equals(StateEvent.ActionValue.LIVE_DATA_CB)) {
                    k kVar2 = k.a.f100197a;
                    kVar2.a(2, "YouTuSdkHelper", "live data cb!");
                    this.f100119a.getClass();
                    String str5 = (String) hashMap.get(StateEvent.Name.SELECT_DATA_S);
                    String str6 = (String) hashMap.get(StateEvent.Name.ACTION_DATA_S);
                    HuiYanBaseCallBack huiYanBaseCallBack7 = HuiYanBaseApi.b.f100031a.f100028b;
                    if (huiYanBaseCallBack7 == null) {
                        kVar2.a(2, "YouTuSdkHelper", "send get live error, base call back is null");
                        return;
                    } else {
                        huiYanBaseCallBack7.onLiveDataCallBackInfo("selectData", str5);
                        huiYanBaseCallBack7.onLiveDataCallBackInfo(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, str6);
                        return;
                    }
                }
                return;
            }
            bVar.a(str2);
        }
        if (hashMap.containsKey(StateEvent.Name.OPERATE_PACK_USE_TIME)) {
            String str7 = (String) hashMap.get(StateEvent.Name.OPERATE_PACK_USE_TIME);
            if (TextUtils.isEmpty(str7)) {
                k.a.f100197a.a(1, "YouTuSdkHelper", "result str is empty.");
                if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT)) {
                }
            } else {
                bVar.a(str7);
            }
        }
        if (hashMap.containsKey(StateEvent.Name.CONSERVATION_VIDEO_MESSAGE)) {
            String str8 = (String) hashMap.get(StateEvent.Name.CONSERVATION_VIDEO_MESSAGE);
            if (TextUtils.isEmpty(str8)) {
                k.a.f100197a.a(1, "YouTuSdkHelper", "result str is empty.");
            } else {
                bVar.a(str8);
            }
        }
        if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT)) {
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener
    public void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, hashMap, iYtSDKKitNetResponseParser);
            return;
        }
        if (str.contains("getLiveType")) {
            HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
            HuiYanBaseCallBack huiYanBaseCallBack = huiYanBaseApi.f100028b;
            if (huiYanBaseCallBack != null) {
                huiYanBaseCallBack.onOperateTimeEvent("GetConfigUseTime", 2, false, "");
            }
            this.f100119a.f100121b = iYtSDKKitNetResponseParser;
            k kVar = k.a.f100197a;
            kVar.a(2, "YouTuSdkHelper", "send call back get live");
            HuiYanBaseCallBack huiYanBaseCallBack2 = huiYanBaseApi.f100028b;
            if (huiYanBaseCallBack2 == null) {
                kVar.a(2, "YouTuSdkHelper", "send get live error, base call back is null");
            } else {
                huiYanBaseCallBack2.getConfigDataSuccess(str2);
            }
        }
        if (str.contains("compare")) {
            this.f100119a.getClass();
            k kVar2 = k.a.f100197a;
            kVar2.a(2, "YouTuSdkHelper", "send live compare result." + Thread.currentThread().getName());
            HuiYanBaseCallBack huiYanBaseCallBack3 = HuiYanBaseApi.b.f100031a.f100028b;
            if (huiYanBaseCallBack3 == null) {
                kVar2.a(2, "YouTuSdkHelper", "send get live error, base call back is null.");
            } else {
                huiYanBaseCallBack3.getCompareResultData(str2);
            }
        }
    }
}
