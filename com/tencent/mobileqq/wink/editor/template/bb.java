package com.tencent.mobileqq.wink.editor.template;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.ab;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class bb extends com.tencent.mobileqq.wink.view.ab {
    public bb(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
        q0(com.tencent.mobileqq.util.x.c(context, 10.0f));
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, int i3, @NonNull @NotNull MetaMaterial metaMaterial) {
        String str;
        boolean z16;
        super.n0(aVar, i3, metaMaterial);
        TextView textView = (TextView) aVar.itemView.findViewById(R.id.f1056966p);
        if (textView != null) {
            Map<String, String> map = metaMaterial.additionalFields;
            if (map != null && map.containsKey("name")) {
                str = metaMaterial.additionalFields.get("name");
            } else {
                str = "\u6a21\u7248";
            }
            textView.setText(str);
            if (this.f326745h == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            } else {
                textView.setTextColor(Color.parseColor("#8CFFFFFF"));
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        return new ab.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfk, viewGroup, false));
    }
}
