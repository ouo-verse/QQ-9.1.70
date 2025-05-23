package com.tencent.mobileqq.richmedia.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.richmedia.section.CommonLayerProgressSection;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R&\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\n0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000f0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR(\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000f0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/f;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtDelegates", "()Ljava/util/List;", "extDelegates", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "getExtPicSections", "extPicSections", "getExtVideoSections", "extVideoSections", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends RFWLayerBasePart implements IDelegateAndSectionProvider {
    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates() {
        List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CommonLayerProgressSection.class);
        return arrayListOf;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    @NotNull
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CommonLayerProgressSection.class);
        return arrayListOf;
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        RFWLayerIOCUtil.registerSectionProvider(rootView, this);
    }
}
