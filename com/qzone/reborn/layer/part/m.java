package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import com.qzone.preview.event.QZoneAlbumLayerSelectPhotoEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/layer/part/m;", "Lcom/qzone/reborn/layer/part/ap;", "", "T9", "U9", "Q9", "", "P9", "Lcooperation/qzone/model/PhotoInfo;", "photoInfo", "", "O9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "G", "J", "MAX_P2V_VIDEO_DURING", "Luk/c;", "H", "Luk/c;", "viewModel", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "I", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "confirmButton", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends ap {

    /* renamed from: G, reason: from kotlin metadata */
    private final long MAX_P2V_VIDEO_DURING = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MAX_P2V_VIDEO_DURING, 15000L);

    /* renamed from: H, reason: from kotlin metadata */
    private uk.c viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private QUICheckBox checkBox;

    /* renamed from: J, reason: from kotlin metadata */
    private QUIButton confirmButton;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r0 != 8) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean O9(PhotoInfo photoInfo) {
        VideoInfo videoInfo;
        uk.c cVar = this.viewModel;
        uk.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        int size = cVar.e2().size();
        uk.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        if (size >= cVar3.getMaxPhotoCount()) {
            com.qzone.reborn.util.o oVar = com.qzone.reborn.util.o.f59556a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String a16 = com.qzone.util.l.a(R.string.f133907d);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026ct_layer_max_select_hint)");
            Object[] objArr = new Object[1];
            uk.c cVar4 = this.viewModel;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar4;
            }
            objArr[0] = Integer.valueOf(cVar2.getMaxPhotoCount());
            String format = String.format(a16, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            oVar.b(format);
            return false;
        }
        uk.c cVar5 = this.viewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar5;
        }
        int pageMode = cVar2.getPageMode();
        if (pageMode != 2) {
            if (pageMode != 3) {
                if (pageMode != 7) {
                }
            } else {
                if (photoInfo.photoType == 2) {
                    com.qzone.reborn.util.o.f59556a.b(com.qzone.util.l.a(R.string.f133917e));
                    return false;
                }
                if (photoInfo.videoflag == 1 && (videoInfo = photoInfo.videodata) != null && videoInfo.videoTime > this.MAX_P2V_VIDEO_DURING) {
                    com.qzone.reborn.util.o oVar2 = com.qzone.reborn.util.o.f59556a;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String a17 = com.qzone.util.l.a(R.string.f133937g);
                    Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_alb\u2026_layer_video_length_hint)");
                    String format2 = String.format(a17, Arrays.copyOf(new Object[]{Long.valueOf(this.MAX_P2V_VIDEO_DURING / 1000)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    oVar2.b(format2);
                    return false;
                }
            }
            return true;
        }
        if (photoInfo.videoflag == 1) {
            com.qzone.reborn.util.o.f59556a.b(com.qzone.util.l.a(R.string.f133927f));
            return false;
        }
        return true;
    }

    private final int P9() {
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        RFWLayerState data = value != null ? value.getData() : null;
        if (data == null) {
            return -1;
        }
        return data.getSelectedPosition() + data.getPositionOffset();
    }

    private final void Q9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return;
        }
        uk.c cVar = this.viewModel;
        uk.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        if (cVar.e2().indexOf(photoInfo.lloc) >= 0) {
            uk.c cVar3 = this.viewModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar3;
            }
            cVar2.e2().remove(photoInfo.lloc);
            String str = photoInfo.lloc;
            Intrinsics.checkNotNullExpressionValue(str, "curPhotoInfo.lloc");
            SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumLayerSelectPhotoEvent(str, false, P9()));
        } else if (O9(photoInfo)) {
            uk.c cVar4 = this.viewModel;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar4;
            }
            cVar2.e2().add(photoInfo.lloc);
            String str2 = photoInfo.lloc;
            Intrinsics.checkNotNullExpressionValue(str2, "curPhotoInfo.lloc");
            SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumLayerSelectPhotoEvent(str2, true, P9()));
        } else {
            RFWLog.e(getTAG(), RFWLog.USR, "photo lloc: " + photoInfo.lloc + ", index: " + P9() + " cannot select");
        }
        T9();
        U9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return;
        }
        uk.c cVar = this.viewModel;
        QUICheckBox qUICheckBox = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        int indexOf = cVar.e2().indexOf(photoInfo.lloc);
        if (indexOf >= 0) {
            uk.c cVar2 = this.viewModel;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar2 = null;
            }
            if (cVar2.getIsNumberCheckBox()) {
                QUICheckBox qUICheckBox2 = this.checkBox;
                if (qUICheckBox2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkBox");
                    qUICheckBox2 = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(indexOf + 1)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                qUICheckBox2.setText(format);
            }
            QUICheckBox qUICheckBox3 = this.checkBox;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            } else {
                qUICheckBox = qUICheckBox3;
            }
            qUICheckBox.setChecked(true);
            return;
        }
        uk.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        if (cVar3.getIsNumberCheckBox()) {
            QUICheckBox qUICheckBox4 = this.checkBox;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkBox");
                qUICheckBox4 = null;
            }
            qUICheckBox4.setText((CharSequence) null);
        }
        QUICheckBox qUICheckBox5 = this.checkBox;
        if (qUICheckBox5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        } else {
            qUICheckBox = qUICheckBox5;
        }
        qUICheckBox.setChecked(false);
    }

    private final void U9() {
        String a16;
        uk.c cVar = this.viewModel;
        QUIButton qUIButton = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        if (cVar.e2().size() > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String a17 = com.qzone.util.l.a(R.string.a8z);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(com.tencent.mobile\u2026.confirm_selected_images)");
            Object[] objArr = new Object[1];
            uk.c cVar2 = this.viewModel;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar2 = null;
            }
            objArr[0] = Integer.valueOf(cVar2.e2().size());
            a16 = String.format(a17, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(a16, "format(format, *args)");
        } else {
            a16 = com.qzone.util.l.a(R.string.gi8);
        }
        QUIButton qUIButton2 = this.confirmButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        } else {
            qUIButton = qUIButton2;
        }
        qUIButton.setText(a16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumSelectLayerSelectPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(uk.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneLayerA\u2026ectViewModel::class.java)");
        this.viewModel = (uk.c) viewModel;
        View findViewById = rootView.findViewById(R.id.mno);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026m_layer_header_check_box)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById;
        this.checkBox = qUICheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            qUICheckBox = null;
        }
        qUICheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.R9(m.this, view);
            }
        });
        QUICheckBox qUICheckBox2 = this.checkBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            qUICheckBox2 = null;
        }
        uk.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        qUICheckBox2.setType(cVar.getIsNumberCheckBox() ? 1 : 0);
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.cli, (ViewGroup) null);
        View findViewById2 = inflate.findViewById(R.id.mnm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "footerView.findViewById(\u2026layer_footer_confirm_btn)");
        QUIButton qUIButton = (QUIButton) findViewById2;
        this.confirmButton = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.S9(m.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388693;
        layoutParams.bottomMargin = com.qzone.reborn.util.r.f59560a.e(30);
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView(inflate, layoutParams);
        }
        U9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        T9();
    }
}
