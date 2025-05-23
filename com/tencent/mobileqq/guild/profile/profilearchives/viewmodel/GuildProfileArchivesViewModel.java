package com.tencent.mobileqq.guild.profile.profilearchives.viewmodel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vh2.bi;
import vh2.l;
import xh2.c;

/* loaded from: classes14.dex */
public class GuildProfileArchivesViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> {
    private static final int PAGE_COUNT = 0;
    private static final String TAG = "Guild.profile.GuildProfileArchivesViewModel";
    public static ViewModelProvider.Factory sViewModelFactory = new a();
    private byte[] mArchiveArkCookie;
    private List<c> mArchiveArkList;
    private List<di> mClientAccountList;
    private byte[] mClientCookie;
    private cn<Boolean> mIsEnd;
    private boolean mIsOwner;
    private List<rv1.a> mProfileArchiveList;
    private cn<Boolean> mRefreshList;

    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new GuildProfileArchivesViewModel(new wy1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements bi {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f231316a;

        b(boolean z16) {
            this.f231316a = z16;
        }

        @Override // vh2.bi
        public void onGetClientAccount(int i3, String str, byte[] bArr, boolean z16, ArrayList<di> arrayList) {
            if (i3 != 0) {
                Object[] objArr = new Object[3];
                boolean z17 = false;
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = str;
                if (GuildProfileArchivesViewModel.this.mClientCookie.length == 0) {
                    z17 = true;
                }
                objArr[2] = Boolean.valueOf(z17);
                QLog.e(GuildProfileArchivesViewModel.TAG, 1, String.format("requestClientList network error, errorCode: %d, errorMessage: %s, isRefresh: %b", objArr));
                return;
            }
            QLog.d(GuildProfileArchivesViewModel.TAG, 1, "requestClientList success");
            GuildProfileArchivesViewModel.this.mClientCookie = bArr;
            if (this.f231316a) {
                GuildProfileArchivesViewModel.this.mClientAccountList = arrayList;
            } else {
                GuildProfileArchivesViewModel.this.mClientAccountList.addAll(arrayList);
            }
            GuildProfileArchivesViewModel.this.updateArchiveList();
        }
    }

    public GuildProfileArchivesViewModel(wy1.a aVar) {
        super(aVar);
        this.mArchiveArkList = new ArrayList();
        this.mClientAccountList = new ArrayList();
        this.mProfileArchiveList = new ArrayList();
        this.mRefreshList = new cn<>();
        cn<Boolean> cnVar = new cn<>();
        this.mIsEnd = cnVar;
        cnVar.setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestArchiveList$0(boolean z16, int i3, String str, boolean z17, byte[] bArr, ArrayList arrayList) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("fetchArchiveArkData result: %d, errMsg: %s, isEnd: %b, cookie: %s, sortedArchives: %s", Integer.valueOf(i3), str, Boolean.valueOf(z17), Arrays.toString(bArr), arrayList));
        }
        if (i3 != 0) {
            QLog.w(TAG, 1, String.format("fetchArchiveArkData failed: %d, errMsg: %s, isEnd: %b, cookie: %s, sortedArchives: %s", Integer.valueOf(i3), str, Boolean.valueOf(z17), Arrays.toString(bArr), arrayList));
        } else {
            processArkList(bArr, arrayList, z17, z16);
        }
    }

    private boolean needRefreshArchiveList(List<rv1.a> list, List<rv1.a> list2) {
        if (list.size() == 0) {
            return true;
        }
        if (list.get(0) == null) {
            list = list.subList(1, list.size());
        }
        if (list.size() != list2.size()) {
            return true;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).b() != list2.get(i3).b() || list.get(i3).e() != list2.get(i3).e()) {
                return true;
            }
        }
        return false;
    }

    private void processArkList(byte[] bArr, ArrayList<c> arrayList, boolean z16, boolean z17) {
        this.mArchiveArkCookie = bArr;
        if (z17) {
            this.mArchiveArkList = arrayList;
        } else {
            this.mArchiveArkList.addAll(arrayList);
        }
        if (this.mIsOwner) {
            requestClientList(z17);
        } else {
            updateArchiveList();
        }
    }

    private void requestClientList(boolean z16) {
        if (z16) {
            this.mClientCookie = new byte[0];
        }
        ((IGPSService) ch.R0(IGPSService.class)).getBindClientService(1, "", this.mClientCookie, new b(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateArchiveList() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mArchiveArkList.size(); i3++) {
            arrayList.add(new rv1.a(this.mArchiveArkList.get(i3)));
        }
        for (int i16 = 0; i16 < this.mClientAccountList.size(); i16++) {
            int i17 = 0;
            while (true) {
                if (i17 < this.mArchiveArkList.size()) {
                    if (TextUtils.equals(this.mClientAccountList.get(i16).getClientId(), String.valueOf(this.mArchiveArkList.get(i17).getClientId()))) {
                        z16 = true;
                        break;
                    }
                    i17++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList.add(new rv1.a(this.mClientAccountList.get(i16)));
            }
        }
        if (needRefreshArchiveList(this.mProfileArchiveList, arrayList)) {
            if (this.mIsOwner) {
                arrayList.add(0, null);
            }
            this.mProfileArchiveList = arrayList;
            cn<Boolean> cnVar = this.mRefreshList;
            Boolean bool = Boolean.TRUE;
            cnVar.postValue(bool);
            this.mIsEnd.postValue(bool);
        }
    }

    public List<rv1.a> getGuildArchivesList() {
        return this.mProfileArchiveList;
    }

    public void initData(String str, String str2, boolean z16) {
        this.mIsOwner = z16;
        requestArchiveList(str, str2, true);
    }

    public cn<Boolean> isEnd() {
        return this.mIsEnd;
    }

    public void loadMoreData(String str, String str2) {
        requestArchiveList(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.mArchiveArkCookie = null;
        this.mArchiveArkList.clear();
    }

    public cn<Boolean> refreshList() {
        return this.mRefreshList;
    }

    public void requestArchiveList(String str, String str2, final boolean z16) {
        if (z16) {
            this.mArchiveArkCookie = null;
        }
        ((IGPSService) ch.R0(IGPSService.class)).fetchArchiveArkData(str, str2, this.mArchiveArkCookie, 0, new l() { // from class: com.tencent.mobileqq.guild.profile.profilearchives.viewmodel.a
            @Override // vh2.l
            public final void onFetchArchiveArkData(int i3, String str3, boolean z17, byte[] bArr, ArrayList arrayList) {
                GuildProfileArchivesViewModel.this.lambda$requestArchiveList$0(z16, i3, str3, z17, bArr, arrayList);
            }
        });
    }
}
