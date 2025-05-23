package com.tencent.mobileqq.wink.pubcover;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.view.BorderView;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.StickerModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0007*\u0004'+/3\u0018\u00002\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/s;", "", "", "j", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "p", "o", "Lcom/tencent/videocut/model/StickerModel;", "", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$b;", DomainData.DOMAIN_NAME, "l", "Lcom/tencent/videocut/model/Size;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/pubcover/s$b;", "callback", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "r", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "a", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "winkStickerFrameLayout", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "b", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "winkStickerBorderView", "Lcom/tencent/mobileqq/wink/editor/dr;", "c", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "d", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "curStickerModel", "e", "Lcom/tencent/mobileqq/wink/pubcover/s$b;", "helperCallback", "com/tencent/mobileqq/wink/pubcover/s$d", "f", "Lcom/tencent/mobileqq/wink/pubcover/s$d;", "gestureDetectorCallback", "com/tencent/mobileqq/wink/pubcover/s$f", "g", "Lcom/tencent/mobileqq/wink/pubcover/s$f;", "stickerOpCallback", "com/tencent/mobileqq/wink/pubcover/s$c", tl.h.F, "Lcom/tencent/mobileqq/wink/pubcover/s$c;", "borderLineCallback", "com/tencent/mobileqq/wink/pubcover/s$e", "i", "Lcom/tencent/mobileqq/wink/pubcover/s$e;", "popupMenuClickListener", "<init>", "(Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;Lcom/tencent/mobileqq/wink/editor/view/BorderView;Lcom/tencent/mobileqq/wink/editor/dr;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkStickerFrameLayout winkStickerFrameLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BorderView winkStickerBorderView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dr tavCutDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkStickerModel curStickerModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b helperCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d gestureDetectorCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f stickerOpCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c borderLineCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e popupMenuClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/pubcover/s$a", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$d;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/videocut/model/Size;", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements BorderView.d {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        @NotNull
        public Size a() {
            return new Size(Integer.valueOf(s.this.winkStickerBorderView.getWidth()), Integer.valueOf(s.this.winkStickerBorderView.getHeight()), null, 4, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        @NotNull
        public Size b() {
            return s.this.tavCutDelegate.M();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.d
        public boolean isValid() {
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/s$b;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull WinkStickerModel stickerModel);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/pubcover/s$e", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$c;", "", "id", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements WinkStickerFrameLayout.c {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.view.WinkStickerFrameLayout.c
        public void a(int id5, @Nullable WinkStickerModel stickerModel) {
            if (id5 == 2) {
                s.this.p(stickerModel);
            } else if (id5 == 3) {
                s.this.o(stickerModel);
            }
        }
    }

    public s(@NotNull WinkStickerFrameLayout winkStickerFrameLayout, @NotNull BorderView winkStickerBorderView, @NotNull dr tavCutDelegate) {
        Intrinsics.checkNotNullParameter(winkStickerFrameLayout, "winkStickerFrameLayout");
        Intrinsics.checkNotNullParameter(winkStickerBorderView, "winkStickerBorderView");
        Intrinsics.checkNotNullParameter(tavCutDelegate, "tavCutDelegate");
        this.winkStickerFrameLayout = winkStickerFrameLayout;
        this.winkStickerBorderView = winkStickerBorderView;
        this.tavCutDelegate = tavCutDelegate;
        d dVar = new d();
        this.gestureDetectorCallback = dVar;
        f fVar = new f();
        this.stickerOpCallback = fVar;
        c cVar = new c();
        this.borderLineCallback = cVar;
        e eVar = new e();
        this.popupMenuClickListener = eVar;
        winkStickerBorderView.setBorderViewEventConsumable(true);
        winkStickerBorderView.setCutSizeCallBack(new a());
        winkStickerBorderView.setGestureDetectorCallback(dVar);
        winkStickerBorderView.setOperationCallback(fVar);
        winkStickerBorderView.setBorderLineCallBack(cVar);
        winkStickerFrameLayout.setPopupMenuClickListener(eVar);
        j();
    }

    private final void j() {
        CardView cardView = (CardView) this.winkStickerFrameLayout.findViewById(R.id.z3d);
        cardView.setCardBackgroundColor(cardView.getContext().getColor(R.color.qui_common_bg_bottom_light));
        ImageView imageView = (ImageView) this.winkStickerFrameLayout.findViewById(R.id.svp);
        imageView.setImageResource(R.drawable.qvideo_skin_tooltips_arrow_down);
        ImageView imageView2 = (ImageView) this.winkStickerFrameLayout.findViewById(R.id.svt);
        imageView2.setImageResource(R.drawable.qvideo_skin_tooltips_arrow_up);
        if (QQTheme.isNowThemeIsNight()) {
            imageView.setImageResource(R.drawable.qvideo_skin_tooltips_arrow_down_dark);
            imageView2.setImageResource(R.drawable.qvideo_skin_tooltips_arrow_up_dark);
        }
        this.winkStickerFrameLayout.setUseSkin(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkStickerModel l(WinkStickerModel stickerModel) {
        String str;
        boolean z16;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        String str2;
        boolean z17;
        MetaMaterial material = stickerModel.getMaterial();
        Object obj = null;
        if (material != null) {
            str = com.tencent.mobileqq.wink.editor.sticker.m.u(material);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (m3 = this.tavCutDelegate.m()) == null || (values = m3.values()) == null) {
            return null;
        }
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            WinkStickerModel winkStickerModel = (WinkStickerModel) next;
            MetaMaterial material2 = winkStickerModel.getMaterial();
            if (material2 != null) {
                str2 = com.tencent.mobileqq.wink.editor.sticker.m.u(material2);
            } else {
                str2 = null;
            }
            MetaMaterial material3 = stickerModel.getMaterial();
            Intrinsics.checkNotNull(material3);
            if (Intrinsics.areEqual(str2, com.tencent.mobileqq.wink.editor.sticker.m.u(material3)) && !Intrinsics.areEqual(winkStickerModel.id, stickerModel.id)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                obj = next;
                break;
            }
        }
        return (WinkStickerModel) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WinkStickerFrameLayout.MenuItem> n(StickerModel stickerModel) {
        ArrayList arrayList = new ArrayList();
        StickerModel.Type type = stickerModel.type;
        if (type == StickerModel.Type.TEXT_TEMPLATE || type == StickerModel.Type.TEXT) {
            arrayList.add(new WinkStickerFrameLayout.MenuItem(2, R.string.f239717n8, R.drawable.m65));
        }
        arrayList.add(new WinkStickerFrameLayout.MenuItem(3, R.string.f239687n5, R.drawable.f162672m31));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(WinkStickerModel stickerModel) {
        if (stickerModel != null) {
            k(stickerModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(WinkStickerModel stickerModel) {
        if (stickerModel != null) {
            this.winkStickerFrameLayout.w();
            b bVar = this.helperCallback;
            if (bVar != null) {
                bVar.a(stickerModel);
            }
        }
    }

    public final void k(@NotNull WinkStickerModel stickerModel) {
        List<? extends WinkStickerModel> listOf;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        this.curStickerModel = null;
        this.winkStickerFrameLayout.w();
        dr drVar = this.tavCutDelegate;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(stickerModel);
        drVar.T(listOf);
    }

    @NotNull
    public final Size m() {
        return new Size(Integer.valueOf(this.winkStickerFrameLayout.getWidth()), Integer.valueOf(this.winkStickerFrameLayout.getHeight()), null, 4, null);
    }

    public final void q() {
        this.winkStickerFrameLayout.w();
    }

    public final void r() {
        this.winkStickerBorderView.G();
    }

    public final void s(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.helperCallback = callback;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/pubcover/s$c", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$c;", "", "dd", "B3", "N2", "b8", "R6", "Landroid/view/View;", "bb", "bc", "ga", "w7", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements BorderView.c {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        @Nullable
        public View bb() {
            return null;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        @Nullable
        public View bc() {
            return null;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        @Nullable
        public View ga() {
            return null;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        @Nullable
        public View w7() {
            return null;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        public void B3() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        public void N2() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        public void R6() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        public void b8() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.c
        public void dd() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/pubcover/s$d", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$b;", "", "getRenderWidth", "getRenderHeight", "i1", "K", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$Direction;", "direction", "", "hc", ICustomDataEditor.STRING_ARRAY_PARAM_6, "va", "pointNum", "Sd", "", "isClickEvent", "isStickerActive", "Pb", "", "positionY", "xg", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements BorderView.b {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public int K() {
            return s.this.winkStickerBorderView.getWidth();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public int getRenderHeight() {
            return s.this.winkStickerBorderView.getHeight();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public int getRenderWidth() {
            return s.this.winkStickerBorderView.getWidth();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void hc(@NotNull BorderView.Direction direction) {
            Intrinsics.checkNotNullParameter(direction, "direction");
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public int i1() {
            return s.this.winkStickerBorderView.getWidth();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void a6() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void va() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void Sd(int pointNum) {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void Pb(boolean isClickEvent, boolean isStickerActive) {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.b
        public void xg(boolean isClickEvent, float positionY) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J*\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016\u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/wink/pubcover/s$f", "Lcom/tencent/mobileqq/wink/editor/view/BorderView$e;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "Landroid/graphics/PointF;", "correctPoint", "", "isMove", "", "y2", "w2", "updatedStickerModel", "M3", "", "tipId", "q9", "A3", "M1", "", "eventX", "eventY", "screenX", "screenY", "e1", "fingerOne", "fingerTwo", "U", "Z0", "W0", "f3", "Landroid/graphics/RectF;", "U4", "K0", "h3", "N4", "u8", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements BorderView.e {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int c(WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2) {
            int i3;
            int i16 = 0;
            if (winkStickerModel2 != null) {
                i3 = winkStickerModel2.layerIndex;
            } else {
                i3 = 0;
            }
            if (winkStickerModel != null) {
                i16 = winkStickerModel.layerIndex;
            }
            return i3 - i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int d(PointF fingerCenter, WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2) {
            Intrinsics.checkNotNullParameter(fingerCenter, "$fingerCenter");
            com.tencent.mobileqq.wink.utils.u uVar = com.tencent.mobileqq.wink.utils.u.f326728a;
            return (int) (uVar.g(fingerCenter, new PointF(winkStickerModel.getCenterInView().f320587x, winkStickerModel.getCenterInView().f320588y)) - uVar.g(fingerCenter, new PointF(winkStickerModel2.getCenterInView().f320587x, winkStickerModel2.getCenterInView().f320588y)));
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        @NotNull
        public RectF K0() {
            return new RectF(s.this.winkStickerFrameLayout.s().left + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.s().top + s.this.winkStickerFrameLayout.getTop(), s.this.winkStickerFrameLayout.s().right + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.s().bottom + s.this.winkStickerFrameLayout.getTop());
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void M1() {
            s.this.winkStickerFrameLayout.w();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public boolean N4() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x0136, code lost:
        
            r1 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, new com.tencent.mobileqq.wink.pubcover.t(r3));
         */
        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public WinkStickerModel U(@NotNull PointF fingerOne, @NotNull PointF fingerTwo) {
            boolean z16;
            long j3;
            boolean z17;
            List sortedWith;
            Object firstOrNull;
            WinkStickerModel winkStickerModel;
            Collection<WinkStickerModel> values;
            Object first;
            Intrinsics.checkNotNullParameter(fingerOne, "fingerOne");
            Intrinsics.checkNotNullParameter(fingerTwo, "fingerTwo");
            s.this.tavCutDelegate.getRenderSize();
            Map<String, WinkStickerModel> m3 = s.this.tavCutDelegate.m();
            boolean z18 = true;
            if (m3 != null && m3.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            IPlayer currentPlayer = s.this.tavCutDelegate.getCurrentPlayer();
            if (currentPlayer != null) {
                j3 = currentPlayer.getCurrentPlayUs();
            } else {
                j3 = 0;
            }
            Map<String, WinkStickerModel> m16 = s.this.tavCutDelegate.m();
            if (m16 != null && m16.size() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                Map<String, WinkStickerModel> m17 = s.this.tavCutDelegate.m();
                if (m17 != null && (values = m17.values()) != null) {
                    first = CollectionsKt___CollectionsKt.first(values);
                    winkStickerModel = (WinkStickerModel) first;
                } else {
                    winkStickerModel = null;
                }
                if (winkStickerModel == null || !winkStickerModel.isVisibleAtCurrentPlayTime(j3)) {
                    z18 = false;
                }
                if (!z18) {
                    return null;
                }
                return winkStickerModel;
            }
            float f16 = fingerOne.x + fingerTwo.x;
            float f17 = 2;
            float f18 = fingerTwo.y;
            final PointF pointF = new PointF(f16 / f17, (f18 + f18) / f17);
            Map<String, WinkStickerModel> m18 = s.this.tavCutDelegate.m();
            if (m18 != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, WinkStickerModel> entry : m18.entrySet()) {
                    if (entry.getValue().isVisibleAtCurrentPlayTime(j3)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    WinkStickerModel winkStickerModel2 = (WinkStickerModel) entry2.getValue();
                    if (com.tencent.mobileqq.wink.utils.u.f326728a.m(fingerOne.x, fingerOne.y, fingerTwo.x, fingerTwo.y, winkStickerModel2.getLeftTopInView().f320587x, winkStickerModel2.getLeftTopInView().f320588y, winkStickerModel2.getRightBottomInView().f320587x, winkStickerModel2.getRightBottomInView().f320588y)) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                Collection values2 = linkedHashMap2.values();
                if (values2 != null && sortedWith != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
                    return (WinkStickerModel) firstOrNull;
                }
            }
            return null;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        @NotNull
        public RectF U4() {
            return new RectF(s.this.winkStickerFrameLayout.v().left + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.v().top, s.this.winkStickerFrameLayout.v().right + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.v().bottom);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void W0(@Nullable WinkStickerModel stickerModel) {
            s.this.p(stickerModel);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void Z0(@Nullable WinkStickerModel stickerModel) {
            s.this.curStickerModel = stickerModel;
            if (stickerModel == null) {
                s.this.winkStickerFrameLayout.w();
                s.this.winkStickerFrameLayout.setManualHide(true);
            } else {
                s.this.winkStickerFrameLayout.x(s.this.n(stickerModel));
                WinkStickerFrameLayout.i(s.this.winkStickerFrameLayout, stickerModel, s.this.l(stickerModel), false, 4, null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        
            r8 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r8, new com.tencent.mobileqq.wink.pubcover.u());
         */
        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public WinkStickerModel e1(float eventX, float eventY, float screenX, float screenY) {
            List sortedWith;
            Object firstOrNull;
            PointF B = s.this.winkStickerFrameLayout.B(new PointF(screenX, screenY));
            float f16 = B.y;
            float f17 = B.x;
            IPlayer currentPlayer = s.this.tavCutDelegate.getCurrentPlayer();
            if (currentPlayer != null) {
                currentPlayer.getCurrentPlayUs();
            }
            WinkStickerModel winkStickerModel = null;
            String str = null;
            WinkStickerModel winkStickerModel2 = null;
            winkStickerModel = null;
            winkStickerModel = null;
            if (s.this.winkStickerFrameLayout.getVisibility() == 0 && s.this.winkStickerFrameLayout.v().contains(f17, f16)) {
                s sVar = s.this;
                Map<String, WinkStickerModel> m3 = sVar.tavCutDelegate.m();
                if (m3 != null) {
                    WinkStickerModel winkStickerModel3 = s.this.curStickerModel;
                    if (winkStickerModel3 != null) {
                        str = winkStickerModel3.id;
                    }
                    winkStickerModel2 = m3.get(str);
                }
                sVar.curStickerModel = winkStickerModel2;
                return s.this.curStickerModel;
            }
            s sVar2 = s.this;
            Map<String, WinkStickerModel> m16 = sVar2.tavCutDelegate.m();
            if (m16 != null) {
                s sVar3 = s.this;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, WinkStickerModel> entry : m16.entrySet()) {
                    WinkStickerModel value = entry.getValue();
                    if (com.tencent.mobileqq.wink.utils.u.f326728a.l(f17, f16, sVar3.winkStickerFrameLayout.q(value), -value.rotate)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Collection values = linkedHashMap.values();
                if (values != null && sortedWith != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
                    winkStickerModel = (WinkStickerModel) firstOrNull;
                }
            }
            sVar2.curStickerModel = winkStickerModel;
            return s.this.curStickerModel;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void f3(@Nullable WinkStickerModel stickerModel) {
            StickerModel.Type type;
            StickerModel.Type type2;
            if (stickerModel != null) {
                type = stickerModel.type;
            } else {
                type = null;
            }
            if (type != StickerModel.Type.TOP_FRAME) {
                if (stickerModel != null) {
                    type2 = stickerModel.type;
                } else {
                    type2 = null;
                }
                if (type2 != StickerModel.Type.BOTTOM_FRAME) {
                    return;
                }
            }
            s.this.winkStickerFrameLayout.m(stickerModel, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        @NotNull
        public RectF h3() {
            return new RectF(s.this.winkStickerFrameLayout.r().left + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.r().top + s.this.winkStickerFrameLayout.getTop(), s.this.winkStickerFrameLayout.r().right + s.this.winkStickerFrameLayout.getLeft(), s.this.winkStickerFrameLayout.r().bottom + s.this.winkStickerFrameLayout.getTop());
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public boolean u8() {
            return false;
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void w2(@Nullable WinkStickerModel stickerModel) {
            if (stickerModel != null) {
                s.this.k(stickerModel);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void y2(@NotNull WinkStickerModel stickerModel, @Nullable PointF correctPoint, boolean isMove) {
            Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
            s.this.curStickerModel = stickerModel;
            s.this.tavCutDelegate.t(stickerModel, true);
            s.this.winkStickerFrameLayout.setIsCover(Boolean.TRUE);
            s.this.winkStickerFrameLayout.D(stickerModel);
            if (isMove) {
                s.this.winkStickerFrameLayout.w();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void A3(@Nullable WinkStickerModel stickerModel) {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void M3(@Nullable WinkStickerModel updatedStickerModel) {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.BorderView.e
        public void q9(int tipId) {
        }
    }
}
