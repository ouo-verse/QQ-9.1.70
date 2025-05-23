package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;

/* compiled from: P */
/* loaded from: classes4.dex */
public class AssertUtil {
    private static final String TAG = "AssertUtil";
    private static IAssertUtil assertUtil = null;
    private static final String[] attributesBlackList = {LayoutAttrDefine.MARGIN_LEFT, LayoutAttrDefine.MARGIN_TOP, LayoutAttrDefine.MARGIN_RIGHT, LayoutAttrDefine.MARGIN_BOTTOM, "view_id", CGNonAgeReport.EVENT_TYPE, "height", "width", "value", StringCommon.DEFAULT_VISIBLE};
    private static boolean isDebugVersion = false;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface IAssertUtil {
        void assertInValidAttributesBinding(String str);
    }

    public static void assertInValidAttributesBinding(String str) {
        if (isDebugVersion && assertUtil != null) {
            for (String str2 : attributesBlackList) {
                if (TextUtils.equals(str2, str)) {
                    assertUtil.assertInValidAttributesBinding(str);
                    return;
                }
            }
        }
    }

    public static boolean isDebugVersion() {
        return isDebugVersion;
    }

    public static void registerAssertUtil(IAssertUtil iAssertUtil) {
        boolean z16;
        if (iAssertUtil != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        isDebugVersion = z16;
        assertUtil = iAssertUtil;
    }
}
