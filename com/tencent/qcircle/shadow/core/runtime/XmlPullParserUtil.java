package com.tencent.qcircle.shadow.core.runtime;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.InflateException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes22.dex */
public class XmlPullParserUtil {
    public static String getLayoutStartTagName(Resources resources, int i3) {
        int next;
        try {
            XmlResourceParser layout = resources.getLayout(i3);
            if (layout == null) {
                return null;
            }
            do {
                next = layout.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return layout.getName();
            }
            throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
        } catch (XmlPullParserException e16) {
            InflateException inflateException = new InflateException(e16.getMessage(), e16);
            inflateException.setStackTrace(new StackTraceElement[0]);
            throw inflateException;
        } catch (Exception e17) {
            InflateException inflateException2 = new InflateException(e17.getMessage(), e17);
            inflateException2.setStackTrace(new StackTraceElement[0]);
            throw inflateException2;
        }
    }
}
