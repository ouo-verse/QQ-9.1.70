package com.tencent.mobileqq.guild.channel.create.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.viewmodel.GuildSubChannelCreateViewModel;
import com.tencent.mobileqq.guild.event.GuildUserCreateFeedChannelEvent;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.d;
import com.tencent.mobileqq.qqguildsdk.data.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import of1.GuildCreateTextChannelSubType;
import vh2.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildSubChannelCreateViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> {
    public static final String TAG = "Guild.c.create.GuildSubChannelCreateViewModel";
    public static final ViewModelProvider.Factory sViewModelFactory = new a();
    private String mAppIconUrl;
    private long mAppId;
    private String mAppName;
    private String mApplicationSubChannelLink;
    private final MutableLiveData<b> mChannelLiveAnchorLiveData;
    private final MutableLiveData<c> mChannelVisibleLiveData;
    private final MutableLiveData<d> mCreateChannelResultData;
    private CreateSubChannelInfo mCreateSubChannelInfo;
    private final MutableLiveData<GuildCreateTextChannelSubType> mGuildTextChannelSubType;
    private boolean mIsInCreate;
    private final String mSelectTipFormat;
    private int mTextChannelSubtypeId;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new GuildSubChannelCreateViewModel(new wy1.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f214858a;

        /* renamed from: b, reason: collision with root package name */
        public IGProChannelInfo f214859b;

        public d(boolean z16, IGProChannelInfo iGProChannelInfo) {
            this.f214858a = z16;
            this.f214859b = iGProChannelInfo;
        }
    }

    public GuildSubChannelCreateViewModel(wy1.a aVar) {
        super(aVar);
        this.mSelectTipFormat = "%d\u4e2a\u8eab\u4efd\u7ec4\u3001%d\u540d\u6210\u5458";
        this.mIsInCreate = false;
        this.mTextChannelSubtypeId = 0;
        this.mApplicationSubChannelLink = null;
        this.mChannelVisibleLiveData = new MutableLiveData<>(new c());
        this.mGuildTextChannelSubType = new MutableLiveData<>();
        this.mCreateChannelResultData = new MutableLiveData<>();
        this.mChannelLiveAnchorLiveData = new MutableLiveData<>(new b(0));
    }

    private String getDefaultChannelName(int i3) {
        if (i3 == 1) {
            return "\u95f2\u804a";
        }
        if (i3 == 2) {
            return "\u8bed\u97f3\u623f";
        }
        if (i3 == 5) {
            return "\u76f4\u64ad\u95f4";
        }
        if (i3 == 6) {
            return this.mAppName;
        }
        if (i3 == 7) {
            return "\u5e16\u5b50\u9891\u9053";
        }
        if (i3 == 8) {
            return "\u4e16\u754c\u9891\u9053";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChannelWithParams$0(int i3, String str, IGProChannelInfo iGProChannelInfo, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 10006) {
            str = QQGuildUIUtil.r(R.string.f143540mc);
        }
        onChannelCreateResult(iGProChannelInfo, i3, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDefaultRoleListSize$1(int i3, String str, List list, List list2, List list3) {
        if (i3 != 0) {
            return;
        }
        if (this.mChannelLiveAnchorLiveData.getValue() != null && !this.mChannelLiveAnchorLiveData.getValue().f214852c.isEmpty()) {
            return;
        }
        this.mChannelLiveAnchorLiveData.postValue(new b(0, new ArrayList(), GuildOpenBindPermissionUtils.e(list)));
    }

    private void onChannelCreateResult(IGProChannelInfo iGProChannelInfo, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        boolean z16 = true;
        QLog.i(TAG, 1, "onChannelCreateResult errCode:" + i3 + ", errMsg:" + str);
        this.mIsInCreate = false;
        boolean p16 = ch.p(iGProSecurityResult);
        if (i3 != 0 || !p16) {
            this.mToastEvent.setValue(new cf1.b(i3, str, iGProSecurityResult));
        }
        if (i3 != 29300) {
            z16 = false;
        }
        if (z16 || (i3 == 0 && p16)) {
            this.mCreateChannelResultData.postValue(new d(z16, iGProChannelInfo));
            String str2 = this.mCreateSubChannelInfo.f214823f;
            if ((str2 == "list_setting" || str2 == "feed_square") && iGProChannelInfo.getType() == 7) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildUserCreateFeedChannelEvent(iGProChannelInfo.getChannelUin(), iGProChannelInfo.getGuildId()));
            }
        }
    }

    private void updateDefaultRoleListSize(CreateSubChannelInfo createSubChannelInfo) {
        if (getChannelType() == 5) {
            ((IGPSService) ch.R0(IGPSService.class)).fetchRoleListWithPermission(createSubChannelInfo.f214821d, 100, new xh2.a() { // from class: rf1.d
                @Override // xh2.a
                public final void a(int i3, String str, List list, List list2, List list3) {
                    GuildSubChannelCreateViewModel.this.lambda$updateDefaultRoleListSize$1(i3, str, list, list2, list3);
                }
            });
        }
    }

    public boolean checkCreateValid(String str) {
        if (this.mIsInCreate) {
            QLog.e(TAG, 1, "submit duplicate while creating\uff01");
            return false;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this.mToastEvent.setValue(new cf1.b(-93, HardCodeUtil.qqStr(R.string.f141910hy)));
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str.trim())) {
            return true;
        }
        this.mToastEvent.setValue(new cf1.b(-90, HardCodeUtil.qqStr(R.string.f141290g_)));
        return false;
    }

    public void createChannelWithParams(String str, int i3) {
        this.mIsInCreate = true;
        if (TextUtils.isEmpty(str)) {
            str = getDefaultChannelName(getChannelType());
        }
        d.a w3 = new d.a().K(getChannelType()).J(this.mTextChannelSubtypeId).H(trimEnd(str)).N(this.mChannelVisibleLiveData.getValue().f214854a).L(this.mChannelVisibleLiveData.getValue().f214855b).M(GuildOpenBindPermissionUtils.d(this.mChannelVisibleLiveData.getValue().f214856c)).I(1).F(i3).v(new ArrayList()).x(new ArrayList()).w(new ArrayList());
        if (getChannelType() == 6) {
            w3.u(this.mAppId);
            if (this.mAppId == MiniAppReportManager.MAX_TIME_VALUE) {
                w3.B(this.mApplicationSubChannelLink);
            }
        } else if (getChannelType() == 5) {
            b value = this.mChannelLiveAnchorLiveData.getValue();
            w3.E(value.f214850a).C(value.f214851b).D(GuildOpenBindPermissionUtils.d(value.f214852c));
        } else if (getChannelType() == 8) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new v(4, 1));
            w3.v(arrayList);
        } else if (getChannelType() == 2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new v(5, 0));
            w3.v(arrayList2);
        }
        com.tencent.mobileqq.qqguildsdk.data.d y16 = w3.y();
        QQGuildHandler qQGuildHandler = (QQGuildHandler) ch.j(QQGuildHandler.class);
        CreateSubChannelInfo createSubChannelInfo = this.mCreateSubChannelInfo;
        qQGuildHandler.L2(createSubChannelInfo.f214821d, y16, null, createSubChannelInfo.f214822e, createSubChannelInfo.f214823f, new g() { // from class: rf1.c
            @Override // vh2.g
            public final void a(int i16, String str2, IGProChannelInfo iGProChannelInfo, IGProSecurityResult iGProSecurityResult) {
                GuildSubChannelCreateViewModel.this.lambda$createChannelWithParams$0(i16, str2, iGProChannelInfo, iGProSecurityResult);
            }
        });
    }

    public String getAppIconUrl() {
        return this.mAppIconUrl;
    }

    public long getAppId() {
        return this.mAppId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public MutableLiveData<b> getChannelLiveAnchorLiveData() {
        return this.mChannelLiveAnchorLiveData;
    }

    public int getChannelType() {
        return this.mCreateSubChannelInfo.f214824h;
    }

    public MutableLiveData<c> getChannelVisibleLiveData() {
        return this.mChannelVisibleLiveData;
    }

    public MutableLiveData<d> getCreateChannelResultData() {
        return this.mCreateChannelResultData;
    }

    public MutableLiveData<GuildCreateTextChannelSubType> getGuildTextChannelSubType() {
        return this.mGuildTextChannelSubType;
    }

    public int getReportLiveAnchorType() {
        int i3 = this.mChannelLiveAnchorLiveData.getValue().f214850a;
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            QLog.e(TAG, 1, "invalid reportLiveAnchorType=" + i3);
            return 0;
        }
        return 3;
    }

    public int getReportVisibleType() {
        int i3 = this.mChannelVisibleLiveData.getValue().f214854a;
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            QLog.e(TAG, 1, "invalid reportVisibleType=" + i3);
            return 0;
        }
        return 3;
    }

    public String getSelectLiveAnchorMemberTips() {
        return String.format("%d\u4e2a\u8eab\u4efd\u7ec4\u3001%d\u540d\u6210\u5458", Integer.valueOf(this.mChannelLiveAnchorLiveData.getValue().f214852c.size()), Integer.valueOf(this.mChannelLiveAnchorLiveData.getValue().f214851b.size()));
    }

    public String getSelectMemberTips() {
        return String.format("%d\u4e2a\u8eab\u4efd\u7ec4\u3001%d\u540d\u6210\u5458", Integer.valueOf(this.mChannelVisibleLiveData.getValue().f214856c.size()), Integer.valueOf(this.mChannelVisibleLiveData.getValue().f214855b.size()));
    }

    public int getTextChannelSubtypeId() {
        return this.mTextChannelSubtypeId;
    }

    public LiveData<cf1.b> getToastEvent() {
        return this.mToastEvent;
    }

    public void init(CreateSubChannelInfo createSubChannelInfo) {
        this.mCreateSubChannelInfo = createSubChannelInfo;
        Bundle bundle = createSubChannelInfo.f214825i;
        if (bundle != null) {
            this.mAppId = bundle.getLong("appId");
            this.mAppName = this.mCreateSubChannelInfo.f214825i.getString("appName");
            this.mAppIconUrl = this.mCreateSubChannelInfo.f214825i.getString("iconUrl");
            QLog.i(TAG, 1, String.format("appId=%d, iconurl=%s", Long.valueOf(this.mAppId), this.mAppIconUrl));
        }
        updateDefaultRoleListSize(createSubChannelInfo);
    }

    public boolean isSupportTextChannelAbility() {
        int i3;
        long j3 = this.mAppId;
        if (j3 != 0) {
            i3 = (int) j3;
        } else {
            i3 = this.mCreateSubChannelInfo.f214824h;
        }
        return ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSupportTextChannleAbility(i3);
    }

    public boolean setApplicationSubChannelLink(String str) {
        if (!ch.D0(str)) {
            this.mToastEvent.setValue(new cf1.b(-1, HardCodeUtil.qqStr(R.string.f147420wu)));
            return false;
        }
        this.mApplicationSubChannelLink = str;
        return true;
    }

    public void setChannelLiveAnchorType(int i3, List<String> list, List<String> list2) {
        this.mChannelLiveAnchorLiveData.postValue(new b(i3, list, list2));
    }

    public void setChannelVisibleType(int i3, List<String> list, List<String> list2) {
        this.mChannelVisibleLiveData.postValue(new c(i3, list, list2));
    }

    public void setGuildTextChannelSubType(GuildCreateTextChannelSubType guildCreateTextChannelSubType) {
        this.mGuildTextChannelSubType.postValue(guildCreateTextChannelSubType);
        if (guildCreateTextChannelSubType != null) {
            this.mTextChannelSubtypeId = guildCreateTextChannelSubType.getId();
        }
    }

    public String trimEnd(String str) {
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        if (length < str.length()) {
            return str.substring(0, length);
        }
        return str;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f214854a;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f214855b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f214856c;

        public c() {
            this.f214854a = 1;
            this.f214855b = new ArrayList();
            this.f214856c = new ArrayList();
        }

        public c(int i3, List<String> list, List<String> list2) {
            this.f214854a = 1;
            this.f214855b = new ArrayList();
            new ArrayList();
            this.f214854a = i3;
            this.f214855b = list;
            this.f214856c = list2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f214850a;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f214851b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f214852c;

        public b(int i3) {
            this.f214850a = 1;
            this.f214851b = new ArrayList();
            this.f214852c = new ArrayList();
            this.f214850a = i3;
        }

        public b(int i3, List<String> list, List<String> list2) {
            this.f214850a = 1;
            this.f214851b = new ArrayList();
            new ArrayList();
            this.f214850a = i3;
            this.f214851b = list;
            this.f214852c = list2;
        }
    }
}
