package b6;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface b {
    void Gc(String str, String str2, DialogInterface.OnClickListener onClickListener);

    void H4(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail, int i3);

    void H8();

    void Ib(String str, String str2);

    void Ka(BusinessFeedData businessFeedData, int i3, long j3);

    void La(BusinessFeedData businessFeedData, int i3);

    void Q7(String str, BusinessFeedData businessFeedData);

    void Vc(String str);

    void Wa(BusinessFeedData businessFeedData, int i3, long j3, int i16);

    void Wb(String str, int i3, String str2);

    void X8(String str, Long l3, String str2, int i3, boolean z16);

    void ab();

    void b4(boolean z16, Bundle bundle);

    void e4(BusinessFeedData businessFeedData, int i3, long j3);

    void h5(long j3, String str);

    void j(int i3, String str, String str2, String str3, boolean z16, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3);

    void j3(String str, Long l3, String str2, int i3, long j3, long j16);

    void la(String str, String str2, Map map);

    void mh(long j3, int i3, Object obj);

    void og(View view, BusinessFeedData businessFeedData, int i3, Object obj);

    void r5(CharSequence charSequence);

    void rb(BusinessFeedData businessFeedData, int i3);

    void scrollToTop();

    void t7(String str, BusinessFeedData businessFeedData, int i3);

    void xb(String str);
}
