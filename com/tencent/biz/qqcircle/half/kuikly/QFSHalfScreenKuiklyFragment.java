package com.tencent.biz.qqcircle.half.kuikly;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.d;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import s30.e;
import s30.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0010H\u0014J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/qqcircle/half/kuikly/QFSHalfScreenKuiklyFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "key", "", "data", "", "t5", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "getDaTongPageId", "", "getChildDaTongPageParams", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getLogTag", "getPageId", "Landroid/content/BroadcastReceiver;", "E", "Landroid/content/BroadcastReceiver;", "kuiklyBroadcastReceiver", "Lcom/tencent/biz/qqcircle/beans/QCircleHalfScreenInitBean;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/beans/QCircleHalfScreenInitBean;", "mInitBean", "<init>", "()V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSHalfScreenKuiklyFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BroadcastReceiver kuiklyBroadcastReceiver;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QCircleHalfScreenInitBean mInitBean;

    /* JADX INFO: Access modifiers changed from: private */
    public final void t5(String key, Object data) {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.broadcastMessage(key, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new e());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public Map<String, Object> getChildDaTongPageParams() {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean = this.mInitBean;
        String str3 = null;
        if (qCircleHalfScreenInitBean != null) {
            str = qCircleHalfScreenInitBean.getH5Url();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        HashMap<String, String> c16 = d.c(str);
        if (c16 != null) {
            str2 = c16.get("qfs_autoshowpannel");
        } else {
            str2 = null;
        }
        if (c16 != null) {
            str3 = c16.get(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID);
        }
        QLog.d(getTAG(), 1, "[getChildDaTongPageParams] autoShow:" + str2 + ",taskId:" + str3);
        if (str2 != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_AUTO_TRIGGER, str2);
        }
        if (str3 != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str3);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gd6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEMI_FLOAT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHalfScreenKuiklyFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        Unit unit = null;
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean = null;
        unit = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleHalfScreenInitBean) {
                qCircleHalfScreenInitBean = (QCircleHalfScreenInitBean) serializableExtra;
            }
            this.mInitBean = qCircleHalfScreenInitBean;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[onCreate] intent is null");
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context context;
        super.onDestroyView();
        BroadcastReceiver broadcastReceiver = this.kuiklyBroadcastReceiver;
        if (broadcastReceiver != null && (context = getContext()) != null) {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.biz.qqcircle.half.kuikly.QFSHalfScreenKuiklyFragment$onViewCreated$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a16 = l.a(intent);
                JSONObject b16 = l.b(intent);
                if (f.f433163a.a(a16)) {
                    QLog.d(QFSHalfScreenKuiklyFragment.this.getTAG(), 1, "[onReceive] eventName:" + a16 + ", data:" + b16);
                    QFSHalfScreenKuiklyFragment.this.t5(a16, b16);
                }
            }
        };
        this.kuiklyBroadcastReceiver = broadcastReceiver;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            l.c(context, broadcastReceiver);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[onViewCreated] context is null, register kuikly broadcast receiver fail.");
        }
    }
}
