package com.tencent.qqnt.qbasealbum.base.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\n\u001aD\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerLaunchUtil;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/widget/ImageView;", "imageView", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "allMediaInfo", "", "currentIndex", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Landroid/os/Bundle;", "customBundle", "containerViewId", "", "b", "Lkotlin/Triple;", "Landroid/content/Intent;", "Ljava/util/UUID;", "a", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {
    private static final Triple<Intent, RFWLayerItemMediaInfo, UUID> a(int i3, List<? extends RFWLayerItemMediaInfo> list, ImageView imageView, Bundle bundle) {
        RFWTransAnimBean transitionBean;
        Intent intent = new Intent();
        RFWLayerInitBean rFWLayerInitBean = new RFWLayerInitBean();
        rFWLayerInitBean.setEnterPos(i3);
        rFWLayerInitBean.setRichMediaDataList(list);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = list.get(i3);
        UUID uuid = UUID.randomUUID();
        if (imageView != null) {
            Object tag = imageView.getTag(R.id.f100755tc);
            if (tag instanceof Integer) {
                rFWLayerInitBean.setMTransAnimBeanCreatorId(((Number) tag).intValue());
            }
            Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
            rFWLayerInitBean.setTransitionBean(RFWLayerLaunchUtil.getTransAnimBean(uuid, imageView, list.get(i3).getLayerPicInfo(), false));
            if (bundle != null && (transitionBean = rFWLayerInitBean.getTransitionBean()) != null) {
                transitionBean.setCarvedAnimOpen(bundle.getBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN));
            }
            Object tag2 = imageView.getTag(R.id.xs5);
            if (tag2 instanceof Boolean) {
                intent.putExtra(RFWLaunchKey.KEY_IS_VIDEO_MUTE, ((Boolean) tag2).booleanValue());
            }
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(RFWLaunchKey.KEY_INIT_BEAN, rFWLayerInitBean);
        return new Triple<>(intent, rFWLayerItemMediaInfo, uuid);
    }

    public static final void b(@NotNull RFWLayerLaunchUtil rFWLayerLaunchUtil, @NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> allMediaInfo, int i3, @NotNull Class<? extends Fragment> fragmentClass, @Nullable Bundle bundle, int i16) {
        Intrinsics.checkNotNullParameter(rFWLayerLaunchUtil, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(allMediaInfo, "allMediaInfo");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intent component1 = a(i3, allMediaInfo, imageView, bundle).component1();
        ((FragmentActivity) context).getIntent().putExtras(component1);
        fragmentManager.beginTransaction().add(i16, fragmentClass, component1.getExtras(), "RFWLayerLaunchUtil").commit();
    }
}
