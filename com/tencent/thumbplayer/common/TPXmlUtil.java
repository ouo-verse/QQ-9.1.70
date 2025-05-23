package com.tencent.thumbplayer.common;

import android.text.TextUtils;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

/* loaded from: classes26.dex */
public class TPXmlUtil {
    private static final String TAG = "TPXmlUtil";

    public static boolean isXmlDocument(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.contains("<?xml")) {
                DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
                return true;
            }
            return false;
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return false;
        }
    }
}
