package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.beans.QFSEmotionParseBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bg {
    public static String a(int i3) {
        String eMCode = QQSysFaceUtil.getEMCode(i3);
        if (TextUtils.isEmpty(eMCode)) {
            return b(i3);
        }
        return "[em]e" + eMCode + QzoneEmotionUtils.EMO_TAIL;
    }

    public static String b(int i3) {
        return HostEmotionUtil.splash2Emo(QQSysFaceUtil.getFaceDescription(i3).replaceAll(h.a(R.string.f172111ng0), h.a(R.string.f172113ng2)).replaceAll(h.a(R.string.nfz), "/MM").replaceAll(h.a(R.string.f2192465w), "/chigua"));
    }

    public static QFSEmotionParseBean c(String str) {
        QFSEmotionParseBean qFSEmotionParseBean = new QFSEmotionParseBean(str);
        if (TextUtils.isEmpty(str)) {
            return qFSEmotionParseBean;
        }
        Matcher matcher = com.tencent.biz.qqcircle.widgets.comment.d.f93568a.matcher(str);
        while (matcher.find()) {
            qFSEmotionParseBean.getIndexList().add(new int[]{matcher.start(), matcher.end()});
        }
        return qFSEmotionParseBean;
    }
}
