package com.tencent.qqnt.qbasealbum.customization.preview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.event.MediaEditDoneEvent;
import com.tencent.qqnt.qbasealbum.event.SelectMediaSizeEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u00105\u001a\u000204\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000006\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000fH\u0016J\"\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016J\u001a\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0012\u0010-\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "Landroid/content/Intent;", "data", "", "handlePreviewEditResult", "intent", "initData", "onNewIntent", "hideMenuBar", "showMenuBar", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "position", "onGalleryItemSelected", "onSendClick", "Landroid/view/View;", "v", "", "busi", "onMagicStickClick", "onBackPressed", "", "isSelect", "onCurrentSelectStatusChangeEvent", "isChecked", "checkFlashPicChange", "onFlashPicChangeEvent", "checkQualityRawChange", "onQualityRawChangeEvent", "type", "onItemClicked", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getTitleView", "getBottomView", "needGestureUp", "checkMediaSelect", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "sendByFile", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "", "pendingIntent", "Ljava/lang/Void;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class PreviewCustomizationBase<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends AbstractPreviewLogic<O> {
    static IPatchRedirector $redirector_;

    @Nullable
    private Void pendingIntent;

    @NotNull
    private SendByFile sendByFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewCustomizationBase(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
        } else {
            this.sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
        }
    }

    private final void handlePreviewEditResult(Intent data) {
        final String stringExtra;
        final String stringExtra2;
        HashMap<String, String> c16;
        HashMap<String, String> hashMap;
        HashMap<String, String> c17;
        g gVar = g.f361234b;
        final LocalMediaInfo c18 = gVar.c(data);
        final LocalMediaInfo d16 = gVar.d(data);
        if (c18 != null && d16 != null) {
            ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(d16) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$handlePreviewEditResult$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ LocalMediaInfo $newVideoMediaInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$newVideoMediaInfo = d16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) d16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "handle preview video edit! path:" + LocalMediaInfo.this.getPath() + "->" + this.$newVideoMediaInfo.getPath() + ", fileSize:" + LocalMediaInfo.this.getFileSize() + "->" + this.$newVideoMediaInfo.getFileSize();
                }
            });
            final String E = LocalMediaDataHub.INSTANCE.a().E(c18, d16);
            if (E != null) {
                String path = d16.getPath();
                Intrinsics.checkNotNull(path);
                com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a16 = CustomizationFacade.f361084a.a();
                if (a16 != null && (c17 = a16.c()) != null) {
                    c17.put(E, path);
                }
                if (c18.getFileSize() != d16.getFileSize()) {
                    SimpleEventBus.getInstance().dispatchEvent(new SelectMediaSizeEvent());
                }
                ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(E) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$handlePreviewEditResult$5$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $it;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$it = E;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) E);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "onActivityResult, infoOriginPath:" + this.$it;
                    }
                });
                return;
            }
            return;
        }
        final boolean z16 = !data.getBooleanExtra(PeakConstants.SEND_PICTURE_ORIGIN, false);
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a17 = customizationFacade.a();
        if (a17 != null) {
            Serializable serializableExtra = data.getSerializableExtra(PeakConstants.SEND_PICTURE_EDIT_PLAY_PARAMS);
            if (serializableExtra instanceof HashMap) {
                hashMap = (HashMap) serializableExtra;
            } else {
                hashMap = null;
            }
            a17.m(hashMap);
        }
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(z16) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$handlePreviewEditResult$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $hasEdit;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$hasEdit = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "handle preview image edit! hasEdit:" + this.$hasEdit;
            }
        });
        if (!z16 || (stringExtra = data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null || (stringExtra2 = data.getStringExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH)) == null) {
            return;
        }
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(stringExtra2, stringExtra) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$handlePreviewEditResult$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $editOriginPath;
            final /* synthetic */ String $editResultPath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$editOriginPath = stringExtra2;
                this.$editResultPath = stringExtra;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) stringExtra2, (Object) stringExtra);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "onActivityResult, editOriginPath:" + this.$editOriginPath + " editResultPath:" + this.$editResultPath;
            }
        });
        final String F = LocalMediaDataHub.INSTANCE.a().F(stringExtra2, stringExtra);
        if (F != null) {
            com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a18 = customizationFacade.a();
            if (a18 != null && (c16 = a18.c()) != null) {
                c16.put(F, stringExtra);
            }
            ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(F) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$handlePreviewEditResult$3$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $it;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$it = F;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) F);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "onActivityResult, infoOriginPath:" + this.$it;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGalleryItemSelected$lambda$0(PreviewCustomizationBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CheckBox flashPicCb = this$0.getFlashPicCb();
        if (flashPicCb != null) {
            flashPicCb.requestLayout();
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public boolean checkFlashPicChange(@NotNull LocalMediaInfo mediaInfo, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, mediaInfo, Boolean.valueOf(isChecked))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public boolean checkMediaSelect(@Nullable LocalMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) mediaInfo)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public boolean checkQualityRawChange(@NotNull LocalMediaInfo mediaInfo, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, mediaInfo, Boolean.valueOf(isChecked))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.ft9, parent, false);
        setBottomRootView(inflate);
        RFWNavigationBarImmersiveHelper.INSTANCE.adjustView(inflate.findViewById(R.id.f27090fa), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        setMagicStickBtn((TextView) inflate.findViewById(R.id.f27310fw));
        setFlashPicCb((CheckBox) inflate.findViewById(R.id.f27200fl));
        setFlashPicTv((TextView) inflate.findViewById(R.id.f27210fm));
        setQualityCb((CheckBox) inflate.findViewById(R.id.f27350g0));
        setQualityTv((TextView) inflate.findViewById(R.id.f27370g2));
        setQualitySize((TextView) inflate.findViewById(R.id.f27360g1));
        setSendBtn((Button) inflate.findViewById(R.id.f27400g5));
        setSelectListView((RecyclerView) inflate.findViewById(R.id.f27230fo));
        setCommentTv((TextView) inflate.findViewById(R.id.f27140ff));
        return inflate;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.a
    @Nullable
    public View getTitleView(@NotNull Context context, @NotNull ViewGroup parent) {
        View view;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.ftb, parent, false);
        setTopRootView(inflate);
        CheckBox checkBox = null;
        if (inflate != null) {
            view = inflate.findViewById(R.id.f27060f8);
        } else {
            view = null;
        }
        setBackBtn(view);
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.f27430g8);
        } else {
            textView = null;
        }
        setTitleTv(textView);
        if (inflate != null) {
            checkBox = (CheckBox) inflate.findViewById(R.id.f27390g4);
        }
        setSelectedBox(checkBox);
        return inflate;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void hideMenuBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void initData(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onActivityResult(final int requestCode, final int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(requestCode, resultCode) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onActivityResult$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $requestCode;
            final /* synthetic */ int $resultCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$requestCode = requestCode;
                this.$resultCode = resultCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onActivityResult, requestCode:" + this.$requestCode + ", resultCode:" + this.$resultCode;
            }
        });
        if (resultCode == -1 && data != null && requestCode == 10000) {
            handlePreviewEditResult(data);
            SimpleEventBus.getInstance().dispatchEvent(new MediaEditDoneEvent());
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onCurrentSelectStatusChangeEvent(@Nullable LocalMediaInfo mediaInfo, final boolean isSelect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, mediaInfo, Boolean.valueOf(isSelect));
            return;
        }
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(isSelect) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onCurrentSelectStatusChangeEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isSelect;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$isSelect = isSelect;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, isSelect);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onCurrentSelectStatusChangeEvent, isSelect:" + this.$isSelect;
            }
        });
        if (isSelect) {
            this.sendByFile.f(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), mediaInfo, true, QAlbumPickerContext.f361201a.f());
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onFlashPicChangeEvent(@NotNull LocalMediaInfo mediaInfo, boolean isChecked) {
        CheckBox qualityCb;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, mediaInfo, Boolean.valueOf(isChecked));
            return;
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (isChecked && (qualityCb = getQualityCb()) != null) {
            qualityCb.setChecked(false);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onGalleryItemSelected(@NotNull LocalMediaInfo mediaInfo, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mediaInfo, position);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        getPreviewData().b(mediaInfo);
        getPreviewData().c(position);
        if (getPhotoCommonData().d()) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(mediaInfo)) {
                CheckBox flashPicCb = getFlashPicCb();
                if (flashPicCb != null) {
                    flashPicCb.setVisibility(8);
                }
                TextView flashPicTv = getFlashPicTv();
                if (flashPicTv != null) {
                    flashPicTv.setVisibility(8);
                }
            } else {
                CheckBox flashPicCb2 = getFlashPicCb();
                if (flashPicCb2 != null) {
                    flashPicCb2.setVisibility(0);
                }
                TextView flashPicTv2 = getFlashPicTv();
                if (flashPicTv2 != null) {
                    flashPicTv2.setVisibility(0);
                }
            }
        }
        if (!getPhotoCommonData().g()) {
            CheckBox qualityCb = getQualityCb();
            if (qualityCb != null) {
                qualityCb.setVisibility(8);
            }
            TextView qualityTv = getQualityTv();
            if (qualityTv != null) {
                qualityTv.setVisibility(8);
            }
            TextView qualitySize = getQualitySize();
            if (qualitySize != null) {
                qualitySize.setVisibility(8);
            }
        }
        if (position == 0 && getPhotoCommonData().d() && com.tencent.qqnt.qbasealbum.ktx.b.o(mediaInfo) && !getPhotoCommonData().g()) {
            ox3.a.a("QBaseAlbum.Customization", PreviewCustomizationBase$onGalleryItemSelected$1.INSTANCE);
            View bottomRootView = getBottomRootView();
            if (bottomRootView != null) {
                bottomRootView.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.customization.preview.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreviewCustomizationBase.onGalleryItemSelected$lambda$0(PreviewCustomizationBase.this);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onItemClicked(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, type);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onMagicStickClick(@NotNull View v3, @Nullable final String busi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3, (Object) busi);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        ox3.a.c("QBaseAlbum.Customization", new Function0<String>(busi) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onMagicStickClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $busi;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$busi = busi;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) busi);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[preview] onMagicStickClick busi:" + this.$busi;
            }
        });
        try {
            g gVar = g.f361234b;
            FragmentActivity activity = getActivity();
            LocalMediaInfo a16 = getPreviewData().a();
            Intrinsics.checkNotNull(a16);
            gVar.i(activity, a16, getPhotoCommonData().j(), busi);
        } catch (NullPointerException e16) {
            ox3.a.f("QBaseAlbum.Customization", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onMagicStickClick$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ NullPointerException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "onMagicStickClick NullPointerException: " + this.$e;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onQualityRawChangeEvent(@NotNull LocalMediaInfo mediaInfo, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, mediaInfo, Boolean.valueOf(isChecked));
            return;
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (isChecked) {
            CheckBox flashPicCb = getFlashPicCb();
            if (flashPicCb != null) {
                flashPicCb.setChecked(false);
            }
            this.sendByFile.g(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), getPhotoCommonData().h(), QAlbumPickerContext.f361201a.f());
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onSendClick() {
        final Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(getPhotoCommonData().h()));
        albumResult.m(getPhotoCommonData().j());
        albumResult.j(getPhotoCommonData().b());
        albumResult.k(getPhotoCommonData().i());
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("ALBUM_RESULT", albumResult);
        ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onSendClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ PreviewCustomizationBase<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                boolean i3 = QAlbumPickerContext.f361201a.i();
                List<LocalMediaInfo> h16 = this.this$0.getPhotoCommonData().h();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = h16.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).getPath());
                }
                return "[preview] onSendClick needActivityResult:" + i3 + ", " + arrayList;
            }
        });
        for (LocalMediaInfo localMediaInfo : getPhotoCommonData().h()) {
            localMediaInfo.setSelectStatus(2);
            com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, 0);
        }
        QAlbumPickerContext qAlbumPickerContext = QAlbumPickerContext.f361201a;
        if (qAlbumPickerContext.i()) {
            getActivity().setResult(-1, new Intent().putExtras(bundle));
        } else {
            g.f361234b.n(getActivity(), bundle);
        }
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.f154816sj);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("aio_type", Integer.valueOf(qAlbumPickerContext.f())), TuplesKt.to("number_sent", Integer.valueOf(getPhotoCommonData().h().size())), TuplesKt.to("is_original", Integer.valueOf(!getPhotoCommonData().j() ? 1 : 0)));
        HashMap<String, String> f16 = getPhotoCommonData().f();
        if (f16 != null) {
            mutableMapOf.putAll(f16);
        }
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(mutableMapOf) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onSendClick$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ Map<String, Object> $extrasMap;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$extrasMap = mutableMapOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mutableMapOf);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[picker] onSendBtnClick finish extrasMap: " + this.$extrasMap;
            }
        });
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c("em_bas_send", 2, new Function0<Map<String, ? extends Object>>(mutableMapOf) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase$onSendClick$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Map<String, Object> $extrasMap;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$extrasMap = mutableMapOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mutableMapOf);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.$extrasMap : (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void showMenuBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
