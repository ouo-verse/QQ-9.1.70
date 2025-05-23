package com.tencent.qqnt.qbasealbum.customization.preview;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 F*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001GB\u001f\b\u0004\u0012\u0006\u0010(\u001a\u00020'\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH&J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\u0006H&J\u001a\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0015H&J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0015H&J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0015H&J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0015H&J\u0012\u0010%\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0006\u0010&\u001a\u00020\u0015R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020\u00018DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u00108\u00a8\u0006H"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/a;", "Landroid/content/Intent;", "intent", "", "initData", "onNewIntent", "hideMenuBar", "showMenuBar", "onBackPressed", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "type", "onItemClicked", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelect", "onCurrentSelectStatusChangeEvent", "position", "onGalleryItemSelected", "onSendClick", "Landroid/view/View;", "v", "", "busi", "onMagicStickClick", "isChecked", "checkQualityRawChange", "onQualityRawChangeEvent", "checkFlashPicChange", "onFlashPicChangeEvent", "checkMediaSelect", "canDrag", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "getPhotoCommonData", "()Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "setPhotoCommonData", "(Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "otherCommonData", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "getOtherCommonData", "()Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "setOtherCommonData", "(Lcom/tencent/qqnt/qbasealbum/customization/common/a;)V", "Lcom/tencent/qqnt/qbasealbum/customization/preview/b;", "previewData", "Lcom/tencent/qqnt/qbasealbum/customization/preview/b;", "getPreviewData", "()Lcom/tencent/qqnt/qbasealbum/customization/preview/b;", "setPreviewData", "(Lcom/tencent/qqnt/qbasealbum/customization/preview/b;)V", "getOtherData", "otherData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AbstractPreviewLogic<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "QBaseAlbum.Customization";

    @NotNull
    private FragmentActivity activity;

    @Nullable
    private O otherCommonData;

    @NotNull
    private com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData;

    @NotNull
    private com.tencent.qqnt.qbasealbum.customization.preview.b previewData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic$b", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.qqnt.qbasealbum.customization.common.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractPreviewLogic(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
            return;
        }
        this.activity = activity;
        this.photoCommonData = photoCommonData;
        com.tencent.qqnt.qbasealbum.customization.common.a otherData = getOtherData();
        Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type O of com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic");
        this.otherCommonData = (O) photoCommonData.a(otherData);
        this.previewData = new com.tencent.qqnt.qbasealbum.customization.preview.b();
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AbstractPreviewLogic<O> this$0;

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
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "PhotoPreviewCustomization init, activity=" + this.this$0.getActivity();
            }
        });
    }

    public final boolean canDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    public abstract boolean checkFlashPicChange(@NotNull LocalMediaInfo mediaInfo, boolean isChecked);

    public abstract boolean checkMediaSelect(@Nullable LocalMediaInfo mediaInfo);

    public abstract boolean checkQualityRawChange(@NotNull LocalMediaInfo mediaInfo, boolean isChecked);

    @NotNull
    public final FragmentActivity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FragmentActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @Nullable
    public final O getOtherCommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (O) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.otherCommonData;
    }

    @NotNull
    protected final com.tencent.qqnt.qbasealbum.customization.common.a getOtherData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.qqnt.qbasealbum.customization.common.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new b();
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.customization.common.b<O> getPhotoCommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.qbasealbum.customization.common.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.photoCommonData;
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.customization.preview.b getPreviewData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.qbasealbum.customization.preview.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.previewData;
    }

    public abstract void hideMenuBar();

    public abstract void initData(@Nullable Intent intent);

    public abstract void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    public abstract void onBackPressed();

    public abstract void onCurrentSelectStatusChangeEvent(@Nullable LocalMediaInfo mediaInfo, boolean isSelect);

    public abstract void onFlashPicChangeEvent(@NotNull LocalMediaInfo mediaInfo, boolean isChecked);

    public abstract void onGalleryItemSelected(@NotNull LocalMediaInfo mediaInfo, int position);

    public abstract void onItemClicked(int type);

    public abstract void onMagicStickClick(@NotNull View v3, @Nullable String busi);

    public abstract void onNewIntent(@Nullable Intent intent);

    public abstract void onQualityRawChangeEvent(@NotNull LocalMediaInfo mediaInfo, boolean isChecked);

    public abstract void onSendClick();

    public final void setActivity(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragmentActivity);
        } else {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
            this.activity = fragmentActivity;
        }
    }

    public final void setOtherCommonData(@Nullable O o16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) o16);
        } else {
            this.otherCommonData = o16;
        }
    }

    public final void setPhotoCommonData(@NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.photoCommonData = bVar;
        }
    }

    public final void setPreviewData(@NotNull com.tencent.qqnt.qbasealbum.customization.preview.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.previewData = bVar;
        }
    }

    public abstract void showMenuBar();
}
