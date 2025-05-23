package com.tencent.qq.minibox.debug;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.minibox.business.api.IMiniBoxDataCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import mqq.app.MobileQQ;
import us3.m;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxDebugFragment extends QIphoneTitleBarFragment {
    private MiniBoxDebugAdapter C;
    private ProgressBar D;
    private cs3.b E = new cs3.b() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.8
        @Override // cs3.b
        public void onDownloadProgress(final int i3, final long j3) {
            MiniBoxDebugFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.8.1
                @Override // java.lang.Runnable
                public void run() {
                    ((TextView) ((QIphoneTitleBarFragment) MiniBoxDebugFragment.this).mContentView.findViewById(R.id.f107416ac)).setText("\u8fdb\u5ea6:" + i3 + " totalSize:" + j3);
                }
            });
        }

        @Override // cs3.b
        public void onDownloadComplete(int i3) {
        }

        @Override // cs3.b
        public void onDownloadFail(int i3) {
        }

        @Override // cs3.b
        public void onDownloadPaused(int i3) {
        }

        @Override // cs3.b
        public void onDownloadStart(long j3) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class MiniBoxDebugAdapter extends RecyclerView.Adapter<i> {

        /* renamed from: m, reason: collision with root package name */
        private final List<MiniBoxAppInfo> f344548m = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MiniBoxAppInfo f344552d;

            a(MiniBoxAppInfo miniBoxAppInfo) {
                this.f344552d = miniBoxAppInfo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                MiniBoxDebugAdapter.this.l0(this.f344552d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MiniBoxAppInfo f344554d;

            b(MiniBoxAppInfo miniBoxAppInfo) {
                this.f344554d = miniBoxAppInfo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                MiniBoxDebugAdapter.this.m0(this.f344554d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        MiniBoxDebugAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(MiniBoxAppInfo miniBoxAppInfo) {
            IMiniGameVAService iMiniGameVAService = (IMiniGameVAService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
            MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = new MiniGameDownloadDataWrapper();
            MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
            miniGameDownloadData.setPkgName(miniBoxAppInfo.getPkgName());
            miniGameDownloadData.setVersionCode(String.valueOf(miniBoxAppInfo.getVersionCode()));
            miniGameDownloadDataWrapper.setData(miniGameDownloadData);
            iMiniGameVAService.launchVA(miniGameDownloadDataWrapper, "letsgo://ymzx?isFromDeeplink=true" + MiniBoxDebugFragment.this.Ch());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(final MiniBoxAppInfo miniBoxAppInfo) {
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).uninstallVirtualApp(miniBoxAppInfo.getPkgName(), new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.MiniBoxDebugAdapter.1
                @Override // kotlin.jvm.functions.Function3
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(Boolean bool, Integer num, String str) {
                    if (bool.booleanValue()) {
                        MiniBoxDebugFragment.this.showToast("\u5378\u8f7d\u6210\u529f");
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.MiniBoxDebugAdapter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MiniBoxDebugAdapter.this.f344548m.remove(miniBoxAppInfo);
                                MiniBoxDebugAdapter.this.notifyDataSetChanged();
                            }
                        });
                        return null;
                    }
                    MiniBoxDebugFragment.this.showToast("\u5378\u8f7d\u5931\u8d25");
                    return null;
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f344548m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull i iVar, int i3) {
            MiniBoxAppInfo miniBoxAppInfo = this.f344548m.get(i3);
            iVar.F.setText(miniBoxAppInfo.getAppName());
            iVar.E.setImageDrawable(URLDrawable.getFileDrawable(miniBoxAppInfo.getIconFilePath(), null));
            iVar.G.setTag(miniBoxAppInfo);
            iVar.G.setOnClickListener(new a(miniBoxAppInfo));
            iVar.H.setOnClickListener(new b(miniBoxAppInfo));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168282fi3, viewGroup, false));
        }

        public void setData(List<MiniBoxAppInfo> list) {
            this.f344548m.clear();
            if (list != null && list.size() > 0) {
                this.f344548m.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MiniBoxDebugFragment.this.Hh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).startDownloadRes();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).stopDownloadRes();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            m.f439991a.m("meta_dream_env_is_debug", z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            m.f439991a.m("force_launch_local_check", z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class h implements Function3<Boolean, Integer, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<MiniBoxDebugFragment> f344563d;

        public h(MiniBoxDebugFragment miniBoxDebugFragment) {
            this.f344563d = new WeakReference<>(miniBoxDebugFragment);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, Integer num, String str) {
            MiniBoxDebugFragment miniBoxDebugFragment;
            WeakReference<MiniBoxDebugFragment> weakReference = this.f344563d;
            if (weakReference == null || (miniBoxDebugFragment = weakReference.get()) == null) {
                return null;
            }
            if (bool.booleanValue()) {
                miniBoxDebugFragment.showToast("\u5b89\u88c5\u6210\u529f\uff01");
                miniBoxDebugFragment.Fh();
                miniBoxDebugFragment.Kh(false);
            } else {
                miniBoxDebugFragment.showToast("\u5b89\u88c5\u5931\u8d25\uff0cerror=" + str);
                miniBoxDebugFragment.Kh(false);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class i extends RecyclerView.ViewHolder {
        ImageView E;
        TextView F;
        Button G;
        Button H;

        public i(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.xhj);
            this.F = (TextView) view.findViewById(R.id.f109366fm);
            this.G = (Button) view.findViewById(R.id.tfk);
            this.H = (Button) view.findViewById(R.id.tfl);
        }
    }

    public static void Bh(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable unused) {
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    p51.a.a(inputStream);
                    p51.a.a(fileOutputStream);
                    return;
                }
            }
        } catch (Throwable unused2) {
            fileOutputStream2 = fileOutputStream;
            p51.a.a(inputStream);
            p51.a.a(fileOutputStream2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ch() {
        return QMMKV.fromV2(getQBaseActivity(), QMMKVFile.FILE_MINI_GAME).decodeString(MiniGameVAMMKVKEY.VA_APPEND_DEEP_LINK, "");
    }

    private String Dh() {
        return QMMKV.fromV2(getQBaseActivity(), QMMKVFile.FILE_MINI_GAME).decodeString(MiniGameVAMMKVKEY.MINIGAME_YUN_ID, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(String str) {
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).installVirtualApp(str, new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        MiniBoxSDK.getInstalledApps(new IMiniBoxDataCallback<List<MiniBoxAppInfo>>() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.11
            @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(final List<MiniBoxAppInfo> list) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniBoxDebugFragment.this.C.setData(list);
                    }
                });
            }

            @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
            public void onFail(int i3, String str) {
                QLog.e("MiniBoxDebugFragment", 1, "[getInstalledApps] failed, errorMsg=" + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Gh(Uri uri) {
        try {
            QLog.i("MiniBoxDebugFragment", 1, "readApkFile: uri=" + uri);
            InputStream openInputStream = getContext().getContentResolver().openInputStream(uri);
            File externalFilesDir = getContext().getExternalFilesDir(null);
            String path = uri.getPath();
            String substring = path.substring(path.lastIndexOf("/"));
            File file = new File(externalFilesDir, substring);
            Log.d("MiniBoxDebugFragment", "targetFile=" + file.getPath() + " fileName=" + substring);
            Bh(openInputStream, file);
            return file.getAbsolutePath();
        } catch (FileNotFoundException e16) {
            QLog.d("MiniBoxDebugFragment", 4, "readApkFile FileNotFoundException.", e16);
            return null;
        } catch (SecurityException e17) {
            QLog.e("MiniBoxDebugFragment", 1, "readApkFile: SecurityException.", e17);
            showToast("\u65e0\u6743\u9650\u8bfb\u53d6Apk\u6587\u4ef6\u3002");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("*/*");
        intent.putExtra("big_brother_source_key", "biz_src_minigame_virtual");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 4096);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(String str) {
        QMMKV.fromV2(getQBaseActivity(), QMMKVFile.FILE_MINI_GAME).encodeString(MiniGameVAMMKVKEY.VA_APPEND_DEEP_LINK, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(String str) {
        QMMKV.fromV2(getQBaseActivity(), QMMKVFile.FILE_MINI_GAME).encodeString(MiniGameVAMMKVKEY.MINIGAME_YUN_ID, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(final boolean z16) {
        int i3;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ProgressBar progressBar = this.D;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.10
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                ProgressBar progressBar2 = MiniBoxDebugFragment.this.D;
                if (z16) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                progressBar2.setVisibility(i16);
            }
        });
    }

    private void initView() {
        this.D = (ProgressBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f28600jd);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tfj).setOnClickListener(new a());
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tfm).setOnClickListener(new b());
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tfn).setOnClickListener(new c());
        CheckBox checkBox = (CheckBox) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.uw9);
        m mVar = m.f439991a;
        boolean g16 = mVar.g("meta_dream_env_is_debug");
        checkBox.setChecked(g16);
        checkBox.setOnCheckedChangeListener(new d());
        QLog.i("MiniBoxDebugFragment", 1, "meta_dream_env_is_debug isDebug:" + g16);
        CheckBox checkBox2 = (CheckBox) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.vdq);
        checkBox2.setChecked(mVar.g("force_launch_local_check"));
        checkBox2.setOnCheckedChangeListener(new e());
        RecyclerView recyclerView = (RecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f790848t);
        this.C = new MiniBoxDebugAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.C);
        Fh();
        ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).registerDownloadCallback(this.E);
        EditText editText = (EditText) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.uw8);
        String Ch = Ch();
        if (!TextUtils.isEmpty(Ch)) {
            editText.setText(Ch);
        }
        editText.addTextChangedListener(new f());
        EditText editText2 = (EditText) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.uwa);
        String Dh = Dh();
        if (!TextUtils.isEmpty(Dh)) {
            editText2.setText(Dh);
        }
        editText2.addTextChangedListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(final String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToast.makeText(requireContext(), 0, str, 0).show();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.12
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(MiniBoxDebugFragment.this.requireContext(), 0, str, 0).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle("\u865a\u62df\u5e94\u7528\u8c03\u8bd5");
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).init(requireContext());
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).preload();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168281fi2;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @androidx.annotation.Nullable final Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 4096 && intent != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.debug.MiniBoxDebugFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    MiniBoxDebugFragment.this.Kh(true);
                    String Gh = MiniBoxDebugFragment.this.Gh(intent.getData());
                    if (TextUtils.isEmpty(Gh)) {
                        MiniBoxDebugFragment.this.showToast("\u62f7\u8d1d\u5b89\u88c5\u5305\u6587\u4ef6\u5931\u8d25\u3002");
                        return;
                    }
                    QLog.d("MiniBoxDebugFragment", 4, "apkFilePath=" + Gh);
                    MiniBoxDebugFragment.this.Eh(Gh);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).unregisterDownloadCallback(this.E);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            MiniBoxDebugFragment.this.Ih(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            MiniBoxDebugFragment.this.Jh(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
