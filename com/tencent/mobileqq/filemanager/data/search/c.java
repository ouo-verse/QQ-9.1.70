package com.tencent.mobileqq.filemanager.data.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends z {
    String H;
    CharSequence I;
    CharSequence J;
    String L;
    public List<FileManagerEntity> G = new ArrayList();
    int K = -1;
    public boolean M = false;

    public c() {
        C(16);
    }

    private String G(long j3) {
        if (j3 < 1024) {
            return String.format("%dB", Long.valueOf(j3));
        }
        BigDecimal bigDecimal = new BigDecimal(j3);
        if (j3 < 1048576) {
            return bigDecimal.divide(new BigDecimal(1024), 2, RoundingMode.HALF_UP).toString() + "KB";
        }
        if (j3 < 1073741824) {
            return bigDecimal.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP).toString() + "MB";
        }
        return bigDecimal.divide(new BigDecimal(1073741824), 2, RoundingMode.HALF_UP).toString() + "GB";
    }

    private void I(boolean z16, int i3, long j3, int i16) {
        String str;
        QLog.d("FileEntitySearchResultModel", 2, "reportResultListViewItem. isClick: " + z16 + ", clickEffect: " + i3 + ", fileSize: " + j3 + ", fileType: " + i16);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_search_result_entry");
        hashMap.put("click_effect", Integer.valueOf(i3));
        hashMap.put("file_size", Long.valueOf(j3));
        hashMap.put("filetype", Integer.valueOf(i16));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("have_result", 1);
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    public void H() {
        List<FileManagerEntity> list = this.G;
        if (list != null && !list.isEmpty()) {
            D(this.G.get(0).Uuid);
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return this.G.get(0).peerUin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        int i3 = this.K;
        if (i3 != 22 && i3 != 23) {
            if (this.I == null) {
                if (this.G.size() == 1) {
                    FileManagerEntity fileManagerEntity = this.G.get(0);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(o());
                    if (fileManagerEntity.nFileType != 13) {
                        spannableStringBuilder.append((CharSequence) " ").append((CharSequence) G(fileManagerEntity.fileSize));
                        spannableStringBuilder.append((CharSequence) " ").append((CharSequence) FileManagerUtil.getFileSizeInvalidTime(fileManagerEntity));
                    } else {
                        String a16 = ap.a(fileManagerEntity.srvTime);
                        String fileOperationTypeToPeer = FileManagerUtil.getFileOperationTypeToPeer(fileManagerEntity);
                        spannableStringBuilder.clear();
                        spannableStringBuilder.append((CharSequence) (a16 + " " + fileOperationTypeToPeer + " " + BaseApplication.getContext().getString(R.string.b6f)));
                    }
                    this.I = spannableStringBuilder;
                } else {
                    Iterator<FileManagerEntity> it = this.G.iterator();
                    long j3 = 0;
                    while (it.hasNext()) {
                        long j16 = it.next().srvTime;
                        if (j3 < j16) {
                            j3 = j16;
                        }
                    }
                    this.I = o();
                }
            }
            return this.I;
        }
        if (this.G.size() > 0) {
            return this.G.get(0).searchPCPart.a(BaseApplication.getContext(), this.G.get(0).fileSize);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.search.model.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence o() {
        CharSequence charSequence = this.J;
        if (charSequence != null) {
            return charSequence;
        }
        int size = this.G.size();
        if (size > 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.mib) + "\"");
            String str = this.H;
            spannableStringBuilder.append(SearchUtils.C(str, str));
            spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) "\u76f8\u5173\u7684\u540c\u540d\u6587\u4ef6\u8bb0\u5f55");
            this.J = spannableStringBuilder;
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        int i3 = 0;
        String trim = FileManagerUtil.getFileOperationTypeToPeer(this.G.get(0)).trim();
        int i16 = 7;
        if (trim.indexOf(HardCodeUtil.qqStr(R.string.mia)) == 0) {
            spannableStringBuilder2.append((CharSequence) "\u6765\u81ea\u591a\u4eba\u804a\u5929: ");
        } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.mi9)) == 0) {
            spannableStringBuilder2.append((CharSequence) "\u53d1\u7ed9\u591a\u4eba\u804a\u5929: ");
        } else {
            i16 = 4;
            if (trim.indexOf(HardCodeUtil.qqStr(R.string.mi_)) == 0) {
                spannableStringBuilder2.append((CharSequence) "\u6765\u81ea\u7fa4: ");
            } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.mi5)) == 0) {
                spannableStringBuilder2.append((CharSequence) "\u53d1\u7ed9\u7fa4: ");
            } else {
                i16 = 2;
                if (trim.indexOf(HardCodeUtil.qqStr(R.string.mi6)) == 0) {
                    spannableStringBuilder2.append((CharSequence) "\u6765\u81ea ");
                } else if (trim.indexOf(HardCodeUtil.qqStr(R.string.mi7)) == 0) {
                    spannableStringBuilder2.append((CharSequence) "\u53d1\u7ed9  ");
                } else {
                    if (trim.indexOf(HardCodeUtil.qqStr(R.string.f171977mi4)) == 0) {
                        spannableStringBuilder2.append((CharSequence) "\u5b58\u5230");
                    }
                    if (i3 != 0) {
                        try {
                            trim = trim.substring(i3);
                        } catch (Exception unused) {
                        }
                    }
                    spannableStringBuilder2.append(SearchUtils.C(trim, this.H));
                    if (this.J == null) {
                        this.J = spannableStringBuilder2;
                    }
                    return this.J;
                }
            }
        }
        i3 = i16;
        if (i3 != 0) {
        }
        spannableStringBuilder2.append(SearchUtils.C(trim, this.H));
        if (this.J == null) {
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeywords() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        CharSequence C = SearchUtils.C(this.G.get(0).fileName, this.H);
        C.toString();
        return C;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        String str;
        int i3 = this.K;
        if (i3 != 22 && i3 != 23) {
            if (view.getContext() instanceof UniteSearchActivity) {
                SearchUtils.W0("all_result", "clk_file", "" + this.H);
            }
            if (this.M) {
                com.tencent.imcore.message.report.a.h(null, 5, 1);
            }
            SearchUtils.c1(this.H, 100, 0, view);
            if (this.G.size() == 1) {
                FileManagerEntity fileManagerEntity = this.G.get(0);
                QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
                FileManagerReporter.a aVar = new FileManagerReporter.a();
                aVar.f209157b = "file_viewer_in";
                aVar.f209158c = 73;
                aVar.f209159d = q.j(fileManagerEntity.fileName);
                aVar.f209160e = fileManagerEntity.fileSize;
                FileManagerReporter.addData(qBaseActivity.getAppRuntime().getCurrentAccountUin(), aVar);
                FileManagerReporter.addData("0X8004AE4");
                if (fileManagerEntity.nFileType == 13) {
                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(fileManagerEntity.Uuid, qBaseActivity, this.K, fileManagerEntity, (AppInterface) qBaseActivity.getAppRuntime());
                    int i16 = this.K;
                    if (i16 == 8) {
                        ReportController.o(null, "dc00898", "", "", "0X800A084", "0X800A084", 0, 0, "", "", "", "");
                    } else if (i16 == 1) {
                        ReportController.o(null, "dc00898", "", "", "0X800A086", "0X800A086", 0, 0, "", "", "", "");
                    }
                } else {
                    dc1.b bVar = new dc1.b((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, fileManagerEntity, 10001);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("from_qlink_enter_recent", false);
                    bundle.putString("c2c_discussion_recentfile", fileManagerEntity.peerUin);
                    if (!TextUtils.isEmpty(this.L)) {
                        bundle.putString("file_browser_extra_params_uin", this.L);
                    }
                    int i17 = fileManagerEntity.nFileType;
                    int i18 = 7;
                    if (i17 != 0 && i17 != 2) {
                        com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) qBaseActivity.getAppRuntime(), fileManagerEntity);
                        dVar.S(bundle);
                        int i19 = this.K;
                        if (i19 != -1) {
                            i18 = i19;
                        }
                        com.tencent.mobileqq.filemanager.openbrowser.c d16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(i18);
                        if (!TextUtils.isEmpty(this.L)) {
                            d16.h(this.L);
                        }
                        d16.e(3);
                        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(qBaseActivity, dVar, d16);
                    } else if (!mb1.a.f416517a.k()) {
                        bVar.x(bundle);
                        dc1.d dVar2 = new dc1.d(qBaseActivity, bVar);
                        dVar2.m(7);
                        int i26 = this.K;
                        if (i26 != -1) {
                            dVar2.m(i26);
                        }
                        dVar2.r(QFileUtils.b0(view.findViewById(R.id.c_5), fileManagerEntity.fileName));
                        dVar2.d();
                    } else {
                        QLog.i("FileEntitySearchResultModel", 1, "new richMedia browser!");
                        if (qBaseActivity.getAppRuntime() instanceof QQAppInterface) {
                            FileManagerUtil.previewSearchFile((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, fileManagerEntity);
                        }
                    }
                }
                FileManagerReporter.addData("0X8006062");
                com.tencent.mobileqq.search.report.b.e(null, 0, this.K, "0X8009D59", 0, 0, null, null);
                return;
            }
            FileManagerReporter.addData("0X8006099");
            com.tencent.mobileqq.search.report.b.e(null, 0, this.K, "0X8009D5B", 0, 0, null, null);
            FileSearchDetailActivity.G2(view.getContext(), getKeywords(), this);
            return;
        }
        List<FileManagerEntity> list = this.G;
        if (list != null && list.size() > 0) {
            FileManagerEntity fileManagerEntity2 = this.G.get(0);
            I(true, 1, fileManagerEntity2.fileSize, fileManagerEntity2.nFileType);
            if (fileManagerEntity2.searchPCPart.i()) {
                QLog.d("FileEntitySearchResultModel", 1, "rootView onClick. fileName: " + fileManagerEntity2.fileName + ", fileId: " + fileManagerEntity2.searchPCPart.f207685a + ", downloadState: " + fileManagerEntity2.searchPCPart.f207689e + ", isFile: " + fileManagerEntity2.searchPCPart.i());
                if (this.K == 22) {
                    str = "OPEN_FILE_DETAIL_EVENT_FOR_PC_ROOT_DIR";
                } else {
                    str = "OPEN_FILE_DETAIL_EVENT_FOR_PC_SUB_DIR";
                }
                Intent intent = new Intent(str);
                intent.putExtra("KEY_FILE_ID", fileManagerEntity2.searchPCPart.f207685a);
                intent.putExtra("KEY_FILE_NAME", fileManagerEntity2.fileName);
                intent.putExtra("KEY_FILE_PATH", fileManagerEntity2.strFilePath);
                intent.putExtra("KEY_FILE_TYPE", ItemType.FILE.ordinal());
                intent.putExtra("KEY_FILE_SIZE", fileManagerEntity2.fileSize);
                BaseApplication.getContext().sendBroadcast(intent);
                return;
            }
            if (fileManagerEntity2.searchPCPart.e()) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_export_file_list_file_id", fileManagerEntity2.searchPCPart.f207685a);
                intent2.putExtra("key_export_file_list_dir_name", fileManagerEntity2.fileName);
                QPublicFragmentActivity.start(view.getContext(), intent2, (Class) FileSearchResultView.G.getSerializable("search_pc_file_list_fragment_cls"));
            }
        }
    }
}
