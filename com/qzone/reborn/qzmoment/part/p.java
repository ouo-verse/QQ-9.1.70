package com.qzone.reborn.qzmoment.part;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/qzmoment/part/p;", "Lan/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "D9", "E9", "onInitView", "v", NodeProps.ON_CLICK, "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends an.a implements View.OnClickListener {
    private final void D9() {
        if (com.qzone.reborn.util.i.b().g("qzone_moment_remove_tips_show_times", 0) > 0) {
            return;
        }
        E9();
        com.qzone.reborn.util.i.b().o("qzone_moment_remove_tips_show_times", 1);
    }

    private final void E9() {
        String str;
        String a16;
        String d16 = com.qzone.reborn.configx.g.f53821a.b().d1();
        HashMap<String, String> b16 = com.qzone.reborn.util.g.b(d16);
        if (b16 == null || (str = b16.get("alert")) == null) {
            return;
        }
        HashMap<String, String> b17 = com.qzone.reborn.util.g.b(d16);
        if (b17 == null || (a16 = b17.get("alert_title")) == null) {
            a16 = com.qzone.util.l.a(R.string.w_e);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, a16, str, com.qzone.util.l.a(R.string.f1338175), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                p.F9(dialogInterface, i3);
            }
        });
        fo.c.f("em_bas_takedown_pop", "pg_bas_consumption", createCustomDialog.getRootView());
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.nhw) {
            E9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        G9(rootView);
    }

    private final void G9(View rootView) {
        View findViewById = rootView != null ? rootView.findViewById(R.id.mgk) : null;
        TextView textView = rootView != null ? (TextView) rootView.findViewById(R.id.nhx) : null;
        TextView textView2 = rootView != null ? (TextView) rootView.findViewById(R.id.nhw) : null;
        HashMap<String, String> b16 = com.qzone.reborn.util.g.b(com.qzone.reborn.configx.g.f53821a.b().d1());
        String str = b16 != null ? b16.get("banner") : null;
        if (str == null || str.length() == 0) {
            if (findViewById == null) {
                return;
            }
            findViewById.setVisibility(8);
            return;
        }
        if (textView != null) {
            textView.setText(str);
        }
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        D9();
        fo.c.o(textView2, "em_bas_takedown_notice", null);
    }
}
