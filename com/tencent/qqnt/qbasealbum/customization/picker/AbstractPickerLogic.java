package com.tencent.qqnt.qbasealbum.customization.picker;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 D*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001EB\u001f\b\u0004\u0012\u0006\u0010,\u001a\u00020+\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0001H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&J\u0016\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000eH&J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0016H&J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0016H&J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000eJ\b\u0010&\u001a\u00020\u0007H&J\"\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010\u0005H&R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0019\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/a;", "generateOtherData", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/content/Context;", "context", "onNewIntent", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelected", "isGesture", "checkMediaSelect", "", "selectedMedia", "onMediaInitEvent", "onMediaSelectEvent", "Landroid/view/View;", "view", "", "layoutPosition", "onItemClickEvent", "isQualityRaw", "checkQualityRawChange", "onQualityRawChangeEvent", "v", "", "business", "onMagicStickClick", "onPreviewBtnClick", "onSendBtnClick", ViewStickEventHelper.IS_SHOW, "onAlbumListShown", "onPickerExit", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "getPhotoCommonData", "()Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "setPhotoCommonData", "(Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "otherCommonData", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/b;", "pickerData", "Lcom/tencent/qqnt/qbasealbum/customization/picker/b;", "Ljava/lang/Class;", "getOtherDataClass", "()Ljava/lang/Class;", "otherDataClass", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AbstractPickerLogic<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends a {
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

    @JvmField
    @NotNull
    public com.tencent.qqnt.qbasealbum.customization.picker.b pickerData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic$b", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35863);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractPickerLogic(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
            return;
        }
        this.activity = activity;
        this.photoCommonData = photoCommonData;
        com.tencent.qqnt.qbasealbum.customization.common.a generateOtherData = generateOtherData();
        Intrinsics.checkNotNull(generateOtherData, "null cannot be cast to non-null type O of com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic");
        this.otherCommonData = (O) photoCommonData.a(generateOtherData);
        this.pickerData = new com.tencent.qqnt.qbasealbum.customization.picker.b();
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AbstractPickerLogic<O> this$0;

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
                return "PhotoListCustomization init, activity=" + this.this$0.getActivity();
            }
        });
    }

    public abstract boolean checkMediaSelect(@NotNull LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture);

    public abstract boolean checkQualityRawChange(boolean isQualityRaw);

    @NotNull
    public com.tencent.qqnt.qbasealbum.customization.common.a generateOtherData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.qbasealbum.customization.common.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new b();
    }

    @NotNull
    public final FragmentActivity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FragmentActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @NotNull
    public final Class<? extends com.tencent.qqnt.qbasealbum.customization.common.a> getOtherDataClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.customization.common.a.class;
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.customization.common.b<O> getPhotoCommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.qbasealbum.customization.common.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.photoCommonData;
    }

    public abstract void initData(@Nullable Intent intent);

    public abstract void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    public final void onAlbumListShown(final boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isShow);
        } else {
            ox3.a.a("QBaseAlbum.Customization", new Function0<String>(isShow) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic$onAlbumListShown$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isShow;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$isShow = isShow;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, isShow);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "onAlbumListShown, isShow:" + this.$isShow;
                }
            });
        }
    }

    public abstract void onItemClickEvent(@NotNull View view, @NotNull LocalMediaInfo mediaInfo, int layoutPosition);

    public abstract void onMagicStickClick(@NotNull View v3, @Nullable String business);

    public void onMediaInitEvent(@NotNull List<LocalMediaInfo> selectedMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) selectedMedia);
        } else {
            Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        }
    }

    public abstract void onMediaSelectEvent(@NotNull LocalMediaInfo mediaInfo, boolean isSelected);

    public abstract void onNewIntent(@Nullable Intent intent, @NotNull Context context);

    public abstract void onPickerExit();

    public abstract void onPreviewBtnClick(@NotNull View v3);

    public abstract void onQualityRawChangeEvent(boolean isQualityRaw);

    public abstract void onSendBtnClick(@NotNull View v3);

    public final void setActivity(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragmentActivity);
        } else {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
            this.activity = fragmentActivity;
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
}
