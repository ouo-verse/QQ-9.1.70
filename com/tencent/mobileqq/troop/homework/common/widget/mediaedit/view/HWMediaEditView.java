package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.MediaListItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001d\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0016\u0010+\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020*0\tH\u0016J\u0016\u0010-\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020,0\tH\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020!H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u0010/\u001a\u00020!H\u0016J\u0012\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000103H\u0016R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010CR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010PR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\n0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010SR \u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010S\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/a;", "Lqs2/a;", "Lqs2/b;", "", "msg", "", "O", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "data", "setData", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "P", "H", "listener", "", "showPickerView", "B", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "manager", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setMediaEditManager", "show", "M", "L", "y", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "height", "w", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/a;", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/b;", "result", "a", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/f;", "l", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/h;", "r", ICustomDataEditor.NUMBER_PARAM_8, "size", "u4", "k4", "g4", "Landroid/graphics/Canvas;", PM.CANVAS, "onDrawForeground", "f", "Z", "showBottomDivider", h.F, "Lkotlin/Lazy;", "E", "()I", "dividerMarginStart", "Landroid/graphics/Paint;", "i", UserInfo.SEX_FEMALE, "()Landroid/graphics/Paint;", "dividerPaint", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f;", BdhLogUtil.LogTag.Tag_Conn, "G", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/f;", "mediaPickerAdapter", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/a;", "D", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/a;", "mediaEditAdapter", "Lqs2/b;", "pickerListener", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "contactAdapter", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "itemObserver", "listObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWMediaEditView extends RecyclerView implements com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a, qs2.a, qs2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a mediaEditAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private qs2.b pickerListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RFWConcatAdapter contactAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Observer<BaseItem> itemObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<BaseItem>> listObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showBottomDivider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividerMarginStart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividerPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f manager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaEditView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
    }

    private final int E() {
        return ((Number) this.dividerMarginStart.getValue()).intValue();
    }

    private final Paint F() {
        return (Paint) this.dividerPaint.getValue();
    }

    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f G() {
        return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f) this.mediaPickerAdapter.getValue();
    }

    private final void H() {
        if (this.mediaEditAdapter == null) {
            if (QLog.isDebugVersion()) {
                QLog.d("HW.MediaEdit.", 4, "initAdapter.");
            }
            setItemAnimator(null);
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a();
            aVar.setHasStableIds(true);
            this.mediaEditAdapter = aVar;
            this.contactAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mediaEditAdapter, G()});
            setLayoutManager(new LinearLayoutManager(getContext()));
            setAdapter(this.contactAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(HWMediaEditView this$0, BaseItem it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.P(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(HWMediaEditView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.setData(it);
    }

    private final void O(String msg2) {
        QQToast.makeText(BaseApplication.context, 1, msg2, 0).show();
    }

    private final void P(BaseItem item) {
        List<BaseItem> list;
        AudioItem audioItem;
        AudioItem audioItem2;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar2 = this.mediaEditAdapter;
        if (aVar2 != null) {
            list = aVar2.getItems();
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        if (item instanceof AudioItem) {
            audioItem = (AudioItem) item;
        } else {
            audioItem = null;
        }
        int i3 = 0;
        if (audioItem != null) {
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                BaseItem baseItem = (BaseItem) obj;
                if (baseItem instanceof AudioItem) {
                    audioItem2 = (AudioItem) baseItem;
                } else {
                    audioItem2 = null;
                }
                if (audioItem2 != null && (aVar = this.mediaEditAdapter) != null) {
                    aVar.notifyItemChanged(i3);
                }
                i3 = i16;
            }
            return;
        }
        int i17 = 0;
        for (Object obj2 : list) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BaseItem baseItem2 = (BaseItem) obj2;
            if (baseItem2 instanceof MediaListItem) {
                Iterator<BaseMediaItem> it = ((MediaListItem) baseItem2).getData().iterator();
                int i19 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().areItemsTheSame(item)) {
                            break;
                        } else {
                            i19++;
                        }
                    } else {
                        i19 = -1;
                        break;
                    }
                }
                if (i19 > -1) {
                    com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar3 = this.mediaEditAdapter;
                    if (aVar3 != null) {
                        aVar3.notifyItemChanged(i17, Integer.valueOf(i19));
                        return;
                    }
                    return;
                }
            } else if (baseItem2.areItemsTheSame(item)) {
                com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar4 = this.mediaEditAdapter;
                if (aVar4 != null) {
                    aVar4.notifyItemChanged(i17);
                    return;
                }
                return;
            }
            i17 = i18;
        }
    }

    private final void setData(List<? extends BaseItem> data) {
        H();
        if (QLog.isDebugVersion()) {
            QLog.d("HW.MediaEdit.", 4, "setData, data:" + data + ", size:" + data.size());
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.a aVar = this.mediaEditAdapter;
        if (aVar != null) {
            aVar.setItems(data);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a
    public void B(@NotNull qs2.b listener, boolean showPickerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, listener, Boolean.valueOf(showPickerView));
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (showPickerView) {
            G().u0(this);
        }
        this.pickerListener = listener;
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.t().removeObserver(this.itemObserver);
            fVar.p().removeObserver(this.listObserver);
        }
        this.manager = null;
    }

    public void M(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, show);
        } else {
            this.showBottomDivider = true;
            invalidate();
        }
    }

    @Override // qs2.c
    public void a(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.a(result);
        }
    }

    @Override // qs2.a
    public void c(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.c(activity);
        }
    }

    @Override // qs2.c
    public void d(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.d(data);
        }
    }

    @Override // qs2.b
    public void g4(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, size);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar == null) {
            return;
        }
        int z16 = fVar.z();
        if (z16 <= 0) {
            O("\u6700\u591a\u4e0a\u4f20" + fVar.v() + "\u4e2a\u6587\u4ef6");
            return;
        }
        qs2.b bVar = this.pickerListener;
        if (bVar != null) {
            bVar.g4(z16);
        }
    }

    @Override // qs2.a
    public void j(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.j(item);
        }
    }

    @Override // qs2.b
    public void k4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar == null) {
            return;
        }
        if (fVar.q() <= 0) {
            O("\u6700\u591a\u4e0a\u4f20" + fVar.o() + "\u4e2a\u56fe\u7247\u548c\u89c6\u9891");
            return;
        }
        qs2.b bVar = this.pickerListener;
        if (bVar != null) {
            bVar.k4();
        }
    }

    @Override // qs2.c
    public void l(@NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.l(data);
        }
    }

    @Override // qs2.a
    public void m(@NotNull BaseItem item, @Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) item, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.m(item, activity);
        }
    }

    @Override // qs2.b
    public void n8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar == null) {
            return;
        }
        if (fVar.u() <= 0) {
            O("\u6700\u591a\u4e0a\u4f20" + fVar.g() + "\u6bb5\u5f55\u97f3");
            return;
        }
        qs2.b bVar = this.pickerListener;
        if (bVar != null) {
            bVar.n8();
        }
    }

    @Override // android.view.View
    public void onDrawForeground(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) canvas);
            return;
        }
        super.onDrawForeground(canvas);
        if (!this.showBottomDivider) {
            return;
        }
        float E = E();
        float height = getHeight() - (F().getStrokeWidth() / 2);
        float width = getWidth();
        if (canvas != null) {
            canvas.drawLine(E, height, width, height, F());
        }
    }

    @Override // qs2.c
    public void r(@NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.r(data);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a
    public void setMediaEditManager(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f manager, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) manager, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        L();
        this.manager = manager;
        manager.t().observe(lifecycleOwner, this.itemObserver);
        manager.p().observe(lifecycleOwner, this.listObserver);
    }

    @Override // qs2.b
    public void u4(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, size);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar == null) {
            return;
        }
        int q16 = fVar.q();
        if (q16 <= 0) {
            O("\u6700\u591a\u4e0a\u4f20" + fVar.o() + "\u4e2a\u56fe\u7247\u548c\u89c6\u9891");
            return;
        }
        qs2.b bVar = this.pickerListener;
        if (bVar != null) {
            bVar.u4(q16);
        }
    }

    @Override // qs2.a
    public void w(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, height);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.w(height);
        }
    }

    @Override // qs2.a
    public void y(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f fVar = this.manager;
        if (fVar != null) {
            fVar.y(item);
        }
    }

    public /* synthetic */ HWMediaEditView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(HWMediaEditView$dividerMarginStart$2.INSTANCE);
        this.dividerMarginStart = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView$dividerPaint$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWMediaEditView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Paint) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Paint paint = new Paint();
                HWMediaEditView hWMediaEditView = HWMediaEditView.this;
                paint.setStrokeWidth(ViewUtils.dip2px(0.5f));
                paint.setColor(hWMediaEditView.getResources().getColor(R.color.qui_common_border_standard));
                return paint;
            }
        });
        this.dividerPaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(HWMediaEditView$mediaPickerAdapter$2.INSTANCE);
        this.mediaPickerAdapter = lazy3;
        this.itemObserver = new Observer() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWMediaEditView.I(HWMediaEditView.this, (BaseItem) obj);
            }
        };
        this.listObserver = new Observer() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWMediaEditView.K(HWMediaEditView.this, (List) obj);
            }
        };
    }
}
