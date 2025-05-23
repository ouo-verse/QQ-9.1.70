package fw;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.ba;
import com.tencent.biz.qui.noticebar.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static Bitmap a(String str, QQAppInterface qQAppInterface) {
        Bitmap loadedBitmap = FaceDrawable.getUserFaceDrawable(qQAppInterface, str, (byte) 2).getLoadedBitmap();
        if (loadedBitmap == null) {
            return BaseImageUtil.getDefaultFaceBitmap();
        }
        return loadedBitmap;
    }

    private static void b(c cVar, boolean z16) {
        if (z16) {
            if (cVar.getView().getVisibility() != 0) {
                cVar.getView().setVisibility(0);
            }
            BannerManager l3 = BannerManager.l();
            int i3 = MultiVideoBannerProcessor.f185233d;
            if (l3.g(i3) != 2) {
                BannerManager.l().K(i3, 2);
                return;
            }
            return;
        }
        if (cVar.getView().getVisibility() == 0) {
            cVar.getView().setVisibility(8);
        }
        BannerManager l16 = BannerManager.l();
        int i16 = MultiVideoBannerProcessor.f185233d;
        if (l16.g(i16) != 0) {
            BannerManager.l().K(i16, 0);
        }
    }

    public static void c(QQAppInterface qQAppInterface, c cVar, Message message, boolean z16) {
        boolean z17;
        String string;
        boolean z18;
        Object obj;
        Vector<AVNotifyCenter.h> s16;
        if (qQAppInterface == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        if (message != null && (obj = message.obj) != null) {
            long longValue = ((Long) obj).longValue();
            if (qQAppInterface.getAVNotifyCenter().l(longValue) == 2 && (s16 = qQAppInterface.getAVNotifyCenter().s(longValue)) != null && !s16.isEmpty()) {
                Iterator<AVNotifyCenter.h> it = s16.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BitmapDrawable(cVar.getView().getResources(), a(String.valueOf(it.next().f73805a), qQAppInterface)));
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(ResourcesCompat.getDrawable(cVar.getView().getResources(), R.drawable.gp9, null));
        }
        cVar.i(arrayList);
        int L = qQAppInterface.getAVNotifyCenter().L();
        int J = qQAppInterface.getAVNotifyCenter().J();
        long u16 = qQAppInterface.getAVNotifyCenter().u();
        if (qQAppInterface.getAVNotifyCenter().N() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("MultiVideoBarHelper", 1, "updateMultiVideoBar, randomStatus[" + J + "], sessionType[" + L + "], guildGroupId[" + u16 + "], getSmallScreenState[" + qQAppInterface.getAVNotifyCenter().N() + "]");
        }
        int i3 = R.string.dft;
        if (u16 > 0) {
            int v3 = qQAppInterface.getAVNotifyCenter().v();
            if (v3 < 2) {
                cVar.e(R.string.f170267kp);
            } else {
                String t16 = qQAppInterface.getAVNotifyCenter().t();
                if (t16 != null && t16.equals("1")) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    i3 = R.string.dfu;
                }
                String string2 = qQAppInterface.getApp().getString(i3);
                String q16 = qQAppInterface.getAVNotifyCenter().q();
                cVar.setMsg(String.format(string2, Integer.valueOf(v3)) + " " + q16);
            }
            b(cVar, z17);
        } else if (J == 6) {
            cVar.setMsg(qQAppInterface.getApp().getString(R.string.dfv));
            b(cVar, z17);
        } else if (J >= 5) {
            cVar.setMsg((qQAppInterface.getApp().getString(R.string.dft) + " ") + qQAppInterface.getAVNotifyCenter().q());
            b(cVar, z17);
        } else if (J >= 1 && J < 5) {
            cVar.setMsg(qQAppInterface.getApp().getString(R.string.d9h));
            b(cVar, z17);
        } else if (L != 3 && L != 4) {
            if (L == 1) {
                if (qQAppInterface.getAVNotifyCenter().k0()) {
                    cVar.e(R.string.dmu);
                } else {
                    String q17 = qQAppInterface.getAVNotifyCenter().q();
                    cVar.setMsg(qQAppInterface.getApp().getString(R.string.d99) + " " + q17);
                }
                ba.setAccText(cVar.getView(), qQAppInterface.getApp().getString(R.string.f170489sp));
                b(cVar, z17);
            } else if (L == 2 && !qQAppInterface.getAVNotifyCenter().c0()) {
                if (qQAppInterface.getAVNotifyCenter().k0()) {
                    cVar.e(R.string.dmu);
                } else {
                    String q18 = qQAppInterface.getAVNotifyCenter().q();
                    cVar.setMsg(qQAppInterface.getApp().getString(R.string.dm5) + " " + q18);
                }
                ba.setAccText(cVar.getView(), qQAppInterface.getApp().getString(R.string.f170489sp));
                b(cVar, z17);
            } else {
                b(cVar, false);
            }
        } else {
            int l3 = qQAppInterface.getAVNotifyCenter().l(qQAppInterface.getAVNotifyCenter().n());
            int P = qQAppInterface.getAVNotifyCenter().P();
            if (qQAppInterface.getAVNotifyCenter().k0()) {
                cVar.e(R.string.f170267kp);
            } else {
                long n3 = qQAppInterface.getAVNotifyCenter().n();
                int o16 = qQAppInterface.getAVNotifyCenter().o();
                String q19 = qQAppInterface.getAVNotifyCenter().q();
                if (P == 3000) {
                    string = qQAppInterface.getApp().getString(R.string.f170259kg);
                    if (l3 == 2) {
                        string = string.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                    }
                } else if (P == 1) {
                    string = qQAppInterface.getApp().getString(R.string.f170252kb);
                    if (l3 == 2) {
                        string = string.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiVideoBarHelper", 2, "updateMultiVideoBar-->wrong type of UinType.uintype=" + P);
                        return;
                    }
                    return;
                }
                long y16 = qQAppInterface.getAVNotifyCenter().y(o16, n3);
                if (y16 == 0) {
                    b(cVar, false);
                    return;
                }
                cVar.setMsg(String.format(string, Long.valueOf(y16)) + " " + q19);
            }
            if (P == 1) {
                String string3 = qQAppInterface.getApp().getString(R.string.bho);
                if (l3 == 2) {
                    string3 = string3.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                }
                ba.setAccText(cVar.getView(), string3);
            } else if (P == 3000) {
                String string4 = qQAppInterface.getApp().getString(R.string.bhn);
                if (l3 == 2) {
                    string4 = string4.replace(qQAppInterface.getApp().getString(R.string.f173216i41), qQAppInterface.getApp().getString(R.string.f173217i42));
                }
                ba.setAccText(cVar.getView(), string4);
            }
            b(cVar, z17);
        }
        ReportController.r(qQAppInterface, "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_VIDEO, BaseBannerProcessor.TVALUE_SHOW_VIDEO, 1, 0, "", "", "", "");
    }
}
