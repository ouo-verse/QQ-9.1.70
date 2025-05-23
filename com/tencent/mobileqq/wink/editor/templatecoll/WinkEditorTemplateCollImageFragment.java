package com.tencent.mobileqq.wink.editor.templatecoll;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollImageFragment;", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollAdjustFragment;", "", "getContentLayoutId", "", "getLogTag", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Ch", "M", "Ljava/lang/String;", "TAG", "Landroid/graphics/drawable/ColorDrawable;", "N", "Landroid/graphics/drawable/ColorDrawable;", "colorDrawable", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorTemplateCollImageFragment extends WinkEditorTemplateCollAdjustFragment {

    @NotNull
    public Map<Integer, View> P = new LinkedHashMap();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "WinkEditorTemplateCollClipSegFragment";

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ColorDrawable colorDrawable = new ColorDrawable(570425344);

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void Ch(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Gh();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void _$_clearFindViewByIdCache() {
        this.P.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hep;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f164879u42);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.confirmBtn)");
        c.a(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_APPLY_BUTTON, false);
        View findViewById2 = view.findViewById(R.id.tr7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.changeMediaBtn)");
        c.a(findViewById2, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_BUTTON, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        Bundle arguments = getArguments();
        if (arguments != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            imageView.setImageDrawable(URLDrawable.getFileDrawable(arguments.getString("ARG_IMAGE_PATH"), obtain));
        }
    }
}
