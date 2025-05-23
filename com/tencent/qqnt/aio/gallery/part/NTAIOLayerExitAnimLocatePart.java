package com.tencent.qqnt.aio.gallery.part;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b#\u0010$J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR&\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerExitAnimLocatePart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "tagId", "", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "D9", "childView", "Landroidx/recyclerview/widget/RecyclerView;", "C9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Ljava/util/UUID;", "uuid", "", "id", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "generateTransAnimBean", "", ViewStickEventHelper.IS_SHOW, "updateOriginContainer", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "d", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "mInitBean", "", "e", "Ljava/util/Map;", "elementIdToView", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NTAIOLayerExitAnimLocatePart extends NTAIOLayerBasePart implements RFWTransitionHelper.TransAnimCreator {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWLayerInitBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, WeakReference<View>> elementIdToView;

    public NTAIOLayerExitAnimLocatePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.elementIdToView = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView C9(View childView) {
        if (childView.getParent() instanceof RecyclerView) {
            ViewParent parent = childView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            return (RecyclerView) parent;
        }
        if (childView.getParent() instanceof ViewGroup) {
            Object parent2 = childView.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            return C9((View) parent2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Long, WeakReference<View>> D9(ViewGroup parent, int tagId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = parent.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                linkedHashMap.putAll(D9((ViewGroup) childAt, tagId));
            }
            Object tag = childAt.getTag(tagId);
            if (tag instanceof Long) {
                linkedHashMap.put(tag, new WeakReference(childAt));
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    @Nullable
    public RFWTransAnimBean generateTransAnimBean(@NotNull UUID uuid, @NotNull String id5) {
        Long longOrNull;
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        String str;
        View view;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RFWTransAnimBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uuid, (Object) id5);
        }
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        try {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(id5);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
                if (value != null && (data = value.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
                    for (Object obj : richMediaDataList) {
                        RFWLayerPicInfo layerPicInfo = ((RFWLayerItemMediaInfo) obj).getLayerPicInfo();
                        if (layerPicInfo != null) {
                            str = layerPicInfo.getPicId();
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(id5, str)) {
                            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) obj;
                            if (rFWLayerItemMediaInfo != null) {
                                WeakReference<View> weakReference = this.elementIdToView.get(Long.valueOf(longValue));
                                if (weakReference != null) {
                                    view = weakReference.get();
                                } else {
                                    view = null;
                                }
                                if (view instanceof ImageView) {
                                    imageView = (ImageView) view;
                                } else {
                                    imageView = null;
                                }
                                if (imageView == null) {
                                    return null;
                                }
                                return RFWLayerLaunchUtil.getTransAnimBean(uuid, imageView, rFWLayerItemMediaInfo.getLayerPicInfo(), true);
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            return null;
        } catch (Exception e16) {
            RFWLog.e(getTAG(), RFWLog.USR, e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) getPartHost().getHostActivity().getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        if (rFWLayerInitBean == null) {
            return;
        }
        this.mInitBean = rFWLayerInitBean;
        rFWLayerInitBean.setMTransAnimBeanCreatorId(RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this));
        CorountineFunKt.e(ViewModelKt.getViewModelScope(getMLayerViewModel()), "findAllPicView", Boolean.FALSE, null, null, new NTAIOLayerExitAnimLocatePart$onInitView$1(this, null), 12, null);
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(@NotNull UUID uuid, @NotNull String id5, boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uuid, id5, Boolean.valueOf(isShow));
        } else {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(id5, "id");
        }
    }
}
