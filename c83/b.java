package c83;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.f;
import com.tencent.mobileqq.wink.intermediate.TemplateLibIntermediateFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Lc83/b;", "Lc83/d;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initViewModel", "Lcom/tencent/mobileqq/wink/intermediate/TemplateLibIntermediateFragment;", "fragment", "", "libTemplate", "<init>", "(Lcom/tencent/mobileqq/wink/intermediate/TemplateLibIntermediateFragment;Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends d {
    public b(@Nullable TemplateLibIntermediateFragment templateLibIntermediateFragment, @Nullable String str) {
        super(templateLibIntermediateFragment, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F9(b this$0, a83.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TemplateLibIntermediateMemePart", 1, "requestMaterialRes, getMetaCategoryResult: " + aVar);
        if (aVar.a()) {
            ArrayList<MetaMaterial> arrayList = ((MetaCategory) aVar.f25718a).materials;
            if (arrayList != null && !arrayList.isEmpty()) {
                MetaMaterial material = arrayList.get(0);
                if (Intrinsics.areEqual(QQWinkConstants.TEMPLATE_ID_MAOMEME, material.f30533id)) {
                    Intrinsics.checkNotNullExpressionValue(material, "material");
                    this$0.G9(material);
                    return;
                } else {
                    this$0.f30443f.P1(material);
                    return;
                }
            }
            return;
        }
        this$0.C9(aVar.f25719b);
    }

    private final void G9(MetaMaterial material) {
        Bundle bundle = new Bundle();
        bundle.putAll(this.f30441d.getHostActivity().getIntent().getExtras());
        bundle.putString("key_content", com.tencent.mobileqq.wink.editor.c.M0(material));
        f.o(getContext(), "", bundle);
        this.f30441d.ph(false);
    }

    public final void initViewModel() {
        d83.a aVar = (d83.a) getViewModel(d83.a.class);
        this.f30443f = aVar;
        aVar.M1().observe(getHostFragment(), new Observer() { // from class: c83.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.F9(b.this, (a83.a) obj);
            }
        });
    }

    @Override // c83.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        initViewModel();
        D9();
    }
}
