package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f extends a {
    private String J;
    private CharSequence K;
    private CharSequence L;
    private List<FileManagerEntity> M;

    public f(String str, int i3) {
        super(str, i3);
        this.M = new ArrayList();
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public boolean G() {
        FileManagerEntity fileManagerEntity = this.M.get(0);
        if (fileManagerEntity == null) {
            return false;
        }
        return ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).isSelected(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public List<y> H(QQAppInterface qQAppInterface, Context context) {
        ArrayList arrayList = new ArrayList();
        for (FileManagerEntity fileManagerEntity : this.M) {
            f fVar = new f(this.H, this.G);
            fVar.P(this.I);
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(fileManagerEntity);
            fVar.Q(arrayList2);
            arrayList.add(fVar);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public String I() {
        FileManagerEntity fileManagerEntity = this.M.get(0);
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public String J() {
        String str;
        FileManagerEntity fileManagerEntity = this.M.get(0);
        int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
        if (fileType != 0 && fileType != 2) {
            if (fileType == 5) {
                str = fileManagerEntity.getFilePath();
            } else {
                str = "";
            }
        } else {
            str = fileManagerEntity.strMiddleThumPath;
            if (!q.f(str)) {
                str = fileManagerEntity.strLargeThumPath;
            }
            if (!q.f(str)) {
                str = fileManagerEntity.strThumbPath;
            }
            q.f(str);
        }
        if (fileManagerEntity.nFileType == 13) {
            return ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(fileManagerEntity.Uuid);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public int K() {
        FileManagerEntity fileManagerEntity = this.M.get(0);
        if (fileManagerEntity != null) {
            if (fileManagerEntity.nFileType == 13) {
                return 13;
            }
            return FileManagerUtil.getFileType(fileManagerEntity.fileName);
        }
        return 11;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public int L() {
        return this.M.size();
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void M(View view) {
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        FileSelectorSearchGroupFragment.rh(this);
        Intent intent = new Intent();
        intent.putExtra("qfile_search_param_ex_params", this.I);
        PublicFragmentActivity.startForResult(qBaseActivity, intent, FileSelectorSearchGroupFragment.class, 9999);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void N(View view) {
        FileManagerEntity fileManagerEntity = this.M.get(0);
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        if (fileManagerEntity.nFileType == 13) {
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(fileManagerEntity.Uuid, qBaseActivity, this.G, fileManagerEntity, (AppInterface) qBaseActivity.getAppRuntime());
            return;
        }
        int i3 = this.G;
        if (i3 == 0) {
            i3 = 7;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_qlink_enter_recent", false);
        bundle.putString("c2c_discussion_recentfile", fileManagerEntity.peerUin);
        if (!TextUtils.isEmpty(this.J)) {
            bundle.putString("file_browser_extra_params_uin", this.J);
        }
        int i16 = fileManagerEntity.nFileType;
        if (i16 != 0 && i16 != 2) {
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) qBaseActivity.getAppRuntime(), fileManagerEntity);
            dVar.S(bundle);
            com.tencent.mobileqq.filemanager.openbrowser.c d16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(i3);
            if (!TextUtils.isEmpty(this.J)) {
                d16.h(this.J);
            }
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(qBaseActivity, dVar, d16);
            return;
        }
        if (!mb1.a.f416517a.k()) {
            dc1.b bVar = new dc1.b((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, fileManagerEntity, 10001);
            bVar.x(bundle);
            dc1.d dVar2 = new dc1.d(qBaseActivity, bVar);
            dVar2.m(7);
            int i17 = this.G;
            if (i17 != 0) {
                dVar2.m(i17);
            }
            dVar2.d();
            return;
        }
        QLog.i("RecentFileSearchResultModel", 1, "new richMedia browser!");
        if (qBaseActivity.getAppRuntime() instanceof QQAppInterface) {
            FileManagerUtil.previewSearchFile((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void O(View view) {
        FileManagerEntity fileManagerEntity = this.M.get(0);
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).isSelected(fileManagerEntity)) {
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).removeSelected(fileManagerEntity);
        } else {
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).addSelected(fileManagerEntity);
            ReportController.o(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 1, 0, "0", "0", "", "");
        }
        if (fileManagerEntity.cloudType == 3 && !q.f(fileManagerEntity.getFilePath())) {
            com.tencent.mobileqq.filemanager.util.d.f(FileManagerUtil.cutLongName(fileManagerEntity.fileName) + HardCodeUtil.qqStr(R.string.q9b));
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).removeSelected(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public void P(Bundle bundle) {
        super.P(bundle);
        Bundle bundle2 = this.I;
        if (bundle2 != null) {
            this.J = bundle2.getString("qfile_search_param_ex_params_target_uin", "");
        }
    }

    public void Q(List<FileManagerEntity> list) {
        if (list != null && !list.isEmpty()) {
            if (!TextUtils.isEmpty(this.J) && this.J.equals(AppConstants.DATALINE_PC_UIN)) {
                ArrayList arrayList = new ArrayList();
                for (FileManagerEntity fileManagerEntity : list) {
                    if (!QFileUtils.g0(fileManagerEntity)) {
                        arrayList.add(fileManagerEntity);
                    }
                }
                this.M.addAll(arrayList);
                return;
            }
            this.M.addAll(list);
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (this.K == null) {
            if (this.M.size() == 1) {
                FileManagerEntity fileManagerEntity = this.M.get(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(o());
                if (fileManagerEntity.nFileType != 13) {
                    spannableStringBuilder.append((CharSequence) " ").append((CharSequence) FileManagerUtil.getFileSizeInvalidTime(fileManagerEntity));
                } else {
                    String a16 = ap.a(fileManagerEntity.srvTime);
                    String fileOperationTypeToPeer = FileManagerUtil.getFileOperationTypeToPeer(fileManagerEntity);
                    spannableStringBuilder.clear();
                    spannableStringBuilder.append((CharSequence) (a16 + " " + fileOperationTypeToPeer + " " + BaseApplication.getContext().getString(R.string.b6f)));
                }
                this.K = spannableStringBuilder;
            } else {
                Iterator<FileManagerEntity> it = this.M.iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    long j16 = it.next().srvTime;
                    if (j3 < j16) {
                        j3 = j16;
                    }
                }
                this.K = o();
            }
        }
        return this.K;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.search.model.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence o() {
        CharSequence charSequence = this.L;
        if (charSequence != null) {
            return charSequence;
        }
        int size = this.M.size();
        if (size > 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.mib) + "\"");
            String str = this.H;
            spannableStringBuilder.append(SearchUtils.C(str, str));
            spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) HardCodeUtil.qqStr(R.string.w0c));
            this.L = spannableStringBuilder;
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        int i3 = 0;
        String trim = FileManagerUtil.getFileOperationTypeToPeer(this.M.get(0)).trim();
        int i16 = 7;
        if (trim.indexOf(HardCodeUtil.qqStr(R.string.f170941w05)) == 0) {
            spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.f170941w05) + " "));
        } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.w09)) == 0) {
            spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.w09) + " "));
        } else {
            i16 = 4;
            if (trim.indexOf(HardCodeUtil.qqStr(R.string.w06)) == 0) {
                spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.w06) + " "));
            } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.w0_)) == 0) {
                spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.w0_) + " "));
            } else {
                i16 = 2;
                if (trim.indexOf(HardCodeUtil.qqStr(R.string.f170940w04)) == 0) {
                    spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.f170940w04) + " "));
                } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.w08)) == 0) {
                    spannableStringBuilder2.append((CharSequence) (HardCodeUtil.qqStr(R.string.w08) + "  "));
                } else {
                    if (trim.indexOf(HardCodeUtil.qqStr(R.string.w07)) == 0) {
                        spannableStringBuilder2.append((CharSequence) HardCodeUtil.qqStr(R.string.w07));
                    }
                    if (i3 != 0) {
                        try {
                            trim = trim.toLowerCase().substring(i3);
                        } catch (Exception unused) {
                        }
                    }
                    spannableStringBuilder2.append(SearchUtils.C(trim, this.H));
                    if (this.L == null) {
                        this.L = spannableStringBuilder2;
                    }
                    return this.L;
                }
            }
        }
        i3 = i16;
        if (i3 != 0) {
        }
        spannableStringBuilder2.append(SearchUtils.C(trim, this.H));
        if (this.L == null) {
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return SearchUtils.C(this.M.get(0).fileName.toLowerCase(), this.H);
    }
}
