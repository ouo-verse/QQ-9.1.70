package com.tencent.mobileqq.exportfile.fragment.filelist.download;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment;
import com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a;
import com.tencent.mobileqq.exportfile.fragment.filelist.t;
import com.tencent.mobileqq.exportfile.fragment.filelist.u;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wifiphoto.api.IExportFileApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\tH\u0014J\b\u0010#\u001a\u00020\u0002H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadFragment;", "Lcom/tencent/mobileqq/exportfile/fragment/DisconnectListenerFragment;", "", "Fh", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/data/a;", "state", "Eh", "yh", "Ch", "", "percent", "", "progressText", "Ih", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "Bh", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Dh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "error", "ph", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lm53/f;", "D", "Lm53/f;", "binding", "E", "Ljava/lang/String;", "fileId", UserInfo.SEX_FEMALE, WadlProxyConsts.PARAM_FILENAME, "G", "I", TagName.FILE_TYPE, "Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadViewModel;", "H", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadViewModel;", "viewModel", "", "J", "fileSize", "<init>", "()V", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileDownloadFragment extends DisconnectListenerFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private m53.f binding;

    /* renamed from: E, reason: from kotlin metadata */
    private String fileId;

    /* renamed from: F, reason: from kotlin metadata */
    private String fileName;

    /* renamed from: G, reason: from kotlin metadata */
    private int fileType;

    /* renamed from: H, reason: from kotlin metadata */
    private FileDownloadViewModel viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private long fileSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadFragment$a;", "", "", "KEY_FILE_ID", "Ljava/lang/String;", "KEY_FILE_NAME", "KEY_FILE_SIZE", "KEY_FILE_THUMB", "KEY_FILE_TYPE", "TAG", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileDownloadFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(FileDownloadFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), com.tencent.mobileqq.exportfile.fragment.filelist.b.c(0, 1, null), null, new FileDownloadFragment$downloadBtnInitState$2$1(this$0, null), 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Bh(FileManagerEntity entity) {
        String b16 = t.b(this.fileSize, FileDownloadFragment$downloadComplete$totalSizeText$1.INSTANCE);
        Ih(100, "\u4e0b\u8f7d\u4e2d...(" + b16 + "/" + b16 + ")");
        IExportFileApi iExportFileApi = (IExportFileApi) QRoute.api(IExportFileApi.class);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        iExportFileApi.browserFile(requireActivity, entity);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Ch() {
        m53.f fVar = this.binding;
        m53.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.f416227b.setVisibility(8);
        m53.f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        fVar3.f416232g.setVisibility(0);
        m53.f fVar4 = this.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        fVar4.f416231f.setProgress(0);
        m53.f fVar5 = this.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar2 = fVar5;
        }
        fVar2.f416235j.setText("\u4e0b\u8f7d\u4e2d...(0B/" + t.b(this.fileSize, FileDownloadFragment$downloadStartState$1.INSTANCE) + ")");
    }

    private final HashMap<String, Object> Dh() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dt_pgid", "pg_bas_file_download");
        hashMap.put("file_type", Integer.valueOf(this.fileType));
        hashMap.put("file_size", Long.valueOf(this.fileSize));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a state) {
        if (state instanceof a.c) {
            Ch();
            return;
        }
        if (state instanceof a.d) {
            yh();
            return;
        }
        if (state instanceof a.C7512a) {
            Bh(((a.C7512a) state).a());
            return;
        }
        if (state instanceof a.b) {
            a.b bVar = (a.b) state;
            String a16 = bVar.a();
            String str = this.fileId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileId");
                str = null;
            }
            if (!TextUtils.equals(a16, str)) {
                return;
            }
            Ih(bVar.b(), bVar.c());
        }
    }

    private final void Fh() {
        String str;
        m53.f fVar = this.binding;
        String str2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.f416230e.setCorner(com.tencent.qqnt.qbasealbum.ktx.d.b(11));
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("file_thumb")) == null) {
            str = "";
        }
        String str3 = str;
        if (!TextUtils.isEmpty(str3)) {
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            m53.f fVar2 = this.binding;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar2 = null;
            }
            RoundCornerImageView ivFile = fVar2.f416230e;
            int b16 = com.tencent.qqnt.qbasealbum.ktx.d.b(72);
            int b17 = com.tencent.qqnt.qbasealbum.ktx.d.b(72);
            Context requireContext = requireContext();
            String str4 = this.fileName;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.PARAM_FILENAME);
            } else {
                str2 = str4;
            }
            Drawable drawable = ContextCompat.getDrawable(requireContext, ah.f0(str2));
            Intrinsics.checkNotNullExpressionValue(ivFile, "ivFile");
            iPicAIOApi.loadPic(new com.tencent.mobileqq.pic.option.a(str3, ivFile, true, b16, b17, null, drawable, 32, null));
            return;
        }
        m53.f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        RoundCornerImageView roundCornerImageView = fVar3.f416230e;
        String str5 = this.fileName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.PARAM_FILENAME);
        } else {
            str2 = str5;
        }
        roundCornerImageView.setImageResource(ah.f0(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(FileDownloadFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.fileName;
        m53.f fVar = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.PARAM_FILENAME);
            str = null;
        }
        m53.f fVar2 = this$0.binding;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar2 = null;
        }
        int measuredWidth = fVar2.f416234i.getMeasuredWidth();
        m53.f fVar3 = this$0.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        String M0 = ah.M0(str, false, measuredWidth, fVar3.f416234i.getPaint(), 2);
        m53.f fVar4 = this$0.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        fVar4.f416234i.setText(M0);
        m53.f fVar5 = this$0.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar = fVar5;
        }
        fVar.f416234i.setContentDescription(M0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(FileDownloadFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ih(int percent, String progressText) {
        m53.f fVar = this.binding;
        m53.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.f416227b.setVisibility(8);
        m53.f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        fVar3.f416232g.setVisibility(0);
        m53.f fVar4 = this.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        fVar4.f416231f.setProgress(percent);
        m53.f fVar5 = this.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar5 = null;
        }
        fVar5.f416235j.setText(progressText);
        m53.f fVar6 = this.binding;
        if (fVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar2 = fVar6;
        }
        fVar2.f416235j.setContentDescription(progressText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void yh() {
        m53.f fVar = this.binding;
        m53.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.f416227b.setVisibility(0);
        m53.f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar3 = null;
        }
        fVar3.f416232g.setVisibility(8);
        m53.f fVar4 = this.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        fVar4.f416231f.setProgress(0);
        String str = "\u4e0b\u8f7d(" + t.b(this.fileSize, FileDownloadFragment$downloadBtnInitState$initText$1.INSTANCE) + ")";
        m53.f fVar5 = this.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar5 = null;
        }
        fVar5.f416227b.setText(str);
        m53.f fVar6 = this.binding;
        if (fVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar6 = null;
        }
        fVar6.f416227b.setContentDescription(str);
        com.tencent.mobileqq.wifiphoto.data.a.f(WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD, "pg_bas_file_download", Dh());
        m53.f fVar7 = this.binding;
        if (fVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar7 = null;
        }
        fVar7.f416227b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileDownloadFragment.zh(FileDownloadFragment.this, view);
            }
        });
        m53.f fVar8 = this.binding;
        if (fVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar2 = fVar8;
        }
        fVar2.f416229d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileDownloadFragment.Ah(FileDownloadFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(FileDownloadFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wifiphoto.data.a.d(WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD, "pg_bas_file_download", this$0.Dh());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new FileDownloadFragment$downloadBtnInitState$1$1(this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        long j3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        FileDownloadViewModel fileDownloadViewModel = null;
        if (arguments != null) {
            str = arguments.getString("file_id");
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        this.fileId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("file_name");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        this.fileName = str3;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            j3 = arguments3.getLong("file_size");
        } else {
            j3 = 0;
        }
        this.fileSize = j3;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i3 = arguments4.getInt("file_type");
        } else {
            i3 = 0;
        }
        this.fileType = i3;
        u uVar = u.f205484a;
        String str4 = this.fileId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileId");
            str4 = null;
        }
        FileDownloadViewModel a16 = uVar.a(this, this, str4);
        this.viewModel = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fileDownloadViewModel = a16;
        }
        MutableLiveData<com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a> obtainUiState = fileDownloadViewModel.obtainUiState();
        final FileDownloadFragment$onCreate$1 fileDownloadFragment$onCreate$1 = new FileDownloadFragment$onCreate$1(this);
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileDownloadFragment.onCreate$lambda$0(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            root = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.f g16 = m53.f.g(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
            this.binding = g16;
            m53.f fVar = null;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                g16 = null;
            }
            TextView textView = g16.f416236k;
            String str = this.fileName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.PARAM_FILENAME);
                str = null;
            }
            textView.setText(str);
            m53.f fVar2 = this.binding;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar2 = null;
            }
            TextView textView2 = fVar2.f416236k;
            String str2 = this.fileName;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.PARAM_FILENAME);
                str2 = null;
            }
            textView2.setContentDescription(str2);
            m53.f fVar3 = this.binding;
            if (fVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar3 = null;
            }
            fVar3.f416234i.post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.a
                @Override // java.lang.Runnable
                public final void run() {
                    FileDownloadFragment.Gh(FileDownloadFragment.this);
                }
            });
            m53.f fVar4 = this.binding;
            if (fVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar4 = null;
            }
            fVar4.f416228c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FileDownloadFragment.Hh(FileDownloadFragment.this, view);
                }
            });
            yh();
            Fh();
            m53.f fVar5 = this.binding;
            if (fVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar5 = null;
            }
            VideoReport.setPageId(fVar5.getRoot(), "pg_bas_file_download");
            m53.f fVar6 = this.binding;
            if (fVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fVar = fVar6;
            }
            root = fVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPause();
        m53.f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        VideoReport.reportEvent("pgout", fVar.getRoot(), Dh());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        m53.f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        VideoReport.reportEvent("pgin", fVar.getRoot(), Dh());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarActivityModule.setImmersiveStatus((QBaseActivity) requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNull(requireActivity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity2);
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            view.setPadding(0, RFWImmersiveUtils.getStatusBarHeight(getContext()) - 1, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment
    public void ph(int error) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, error);
            return;
        }
        super.ph(error);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
