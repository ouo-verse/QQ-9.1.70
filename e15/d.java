package e15;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends f {
    public d(String str, View view) {
        super(str, view);
    }

    private int u(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("center".equals(str)) {
                return 13;
            }
            if ("center_horizontal".equals(str)) {
                return 14;
            }
            if ("center_vertical".equals(str)) {
                return 15;
            }
            return 9;
        }
        throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }

    @Override // e15.f
    protected ViewGroup.LayoutParams b(int i3, int i16) {
        return new RelativeLayout.LayoutParams(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        boolean z16 = this.f395367e instanceof RelativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void s(String str, String str2, ViewGroup.LayoutParams layoutParams) {
        String[] split;
        super.s(str, str2, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (LayoutAttrDefine.Gravity.Gravity.equals(str)) {
            layoutParams2.addRule(u(str2));
            return;
        }
        if (ParseCommon.LAYOUT_PARAMS_RELATIVE.equals(str) && (split = str2.split(" ")) != null && split.length == 2) {
            if ("bottom".equals(split[1])) {
                layoutParams2.addRule(3, Integer.parseInt(split[0]));
                layoutParams2.addRule(5, Integer.parseInt(split[0]));
            } else if ("right".equals(split[1])) {
                layoutParams2.addRule(6, Integer.parseInt(split[0]));
            }
        }
    }
}
