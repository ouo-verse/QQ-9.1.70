package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class p {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean n(MessageRecord messageRecord) {
        PicElement picElement;
        if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null || picElement.picSubType != 14) {
            return false;
        }
        return true;
    }

    public static boolean p(MessageRecord messageRecord) {
        PicElement picElement;
        Integer num;
        if (!(messageRecord instanceof MessageForPic) || (picElement = ((MessageForPic) messageRecord).getPicElement()) == null || picElement.picSubType != 13 || (num = picElement.picSubSubType) == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public static boolean w(MessageRecord messageRecord) {
        PicMessageExtraData picMessageExtraData;
        if (!(messageRecord instanceof MessageForPic) || (picMessageExtraData = ((MessageForPic) messageRecord).picExtraData) == null || !picMessageExtraData.isZPlanPic()) {
            return false;
        }
        return true;
    }

    public static p z(Bundle bundle) {
        if (bundle != null && bundle.containsKey("cur_data_source_type")) {
            QLog.d("EmoticonPreviewData", 1, "restoreSaveInstanceState execute");
            int i3 = bundle.getInt("cur_data_source_type");
            if (i3 == 0) {
                return new y(null).A(bundle);
            }
            if (i3 == 1) {
                return new u(null).A(bundle);
            }
            if (i3 == 2) {
                return new y(null).A(bundle);
            }
        }
        return null;
    }

    public abstract CustomEmotionData a();

    public abstract int b(List<p> list);

    public abstract Drawable c(Context context);

    public abstract String d();

    public abstract String e();

    public abstract EmoticonInfo f();

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "";
    }

    public abstract String h();

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return -1L;
    }

    public abstract long k();

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean o();

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public abstract boolean r();

    public abstract boolean s();

    public abstract boolean t(p pVar);

    public abstract boolean u();

    public abstract boolean v();

    public abstract boolean x();

    public void y(Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle, i3);
        } else {
            bundle.putInt("cur_data_source_type", i3);
        }
    }
}
