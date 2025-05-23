package com.tencent.mobileqq.qqexpand.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendHonorOfKingRecordView;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView;
import com.tencent.mobileqq.qqexpand.widget.a;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.NetworkState;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendNewEditFragment extends QPublicBaseFragment implements View.OnClickListener {
    private QBaseActivity C;
    private View D;
    private QQAppInterface E;
    private QQProgressDialog F;
    private ConditionSearchManager G;
    private TextView H;
    private PhotoWallListView I;
    private int K;
    private DynamicAvatarView L;
    private PhotoWallListView.a M;
    private ImageView N;
    private TextView P;
    private ImageView Q;
    private TextView R;

    /* renamed from: g0, reason: collision with root package name */
    private String f263664g0;

    /* renamed from: h0, reason: collision with root package name */
    private EditText f263665h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f263666i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f263667j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f263668k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f263669l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f263670m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f263671n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f263672o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f263673p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f263674q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f263675r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f263676s0;

    /* renamed from: t0, reason: collision with root package name */
    private TextView f263677t0;

    /* renamed from: u0, reason: collision with root package name */
    private QQToast f263678u0;

    /* renamed from: v0, reason: collision with root package name */
    n f263679v0;

    /* renamed from: w0, reason: collision with root package name */
    private View f263680w0;

    /* renamed from: x0, reason: collision with root package name */
    private ExtendFriendHonorOfKingRecordView f263681x0;
    private ArrayList<PhotoWallListView.a> J = new ArrayList<>();
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private String W = "";
    private String X = "";
    private int Y = 0;
    private int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private int f263658a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private int f263659b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private int f263660c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private String f263661d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    private String f263662e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    private String f263663f0 = "";

    /* renamed from: y0, reason: collision with root package name */
    private String f263682y0 = "";

    /* renamed from: z0, reason: collision with root package name */
    private long f263683z0 = 0;
    private long A0 = 3000;
    private ConditionSearchManager.c B0 = new g();
    private final TransProcessorHandler C0 = new h();
    private Runnable D0 = new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.3
        @Override // java.lang.Runnable
        public void run() {
            if (ExtendFriendNewEditFragment.this.J != null && ExtendFriendNewEditFragment.this.K >= 0 && ExtendFriendNewEditFragment.this.J.size() > ExtendFriendNewEditFragment.this.K) {
                String str = ((PhotoWallListView.a) ExtendFriendNewEditFragment.this.J.get(ExtendFriendNewEditFragment.this.K)).f264179b;
                CompressInfo compressInfo = new CompressInfo(str, 0);
                compressInfo.K = 0;
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                if (!StringUtil.isEmpty(compressInfo.H)) {
                    str = compressInfo.H;
                }
                if (!StringUtil.isEmpty(str)) {
                    TransferRequest transferRequest = new TransferRequest();
                    transferRequest.mIsUp = true;
                    transferRequest.mLocalPath = str;
                    transferRequest.mUniseq = System.currentTimeMillis();
                    transferRequest.mFileType = 67;
                    Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
                    commFileExtReq.uint32_action_type.set(0);
                    commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(ExtendFriendNewEditFragment.this.si() + "-" + ExtendFriendNewEditFragment.this.pi(str) + ".jpg"));
                    transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
                    ((ITransFileController) ExtendFriendNewEditFragment.this.E.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
                    return;
                }
                QLog.e("ExtendFriendNewEditFragment", 1, "uploadTask uploadPath is null");
                ExtendFriendNewEditFragment.this.Ai(1, "\u56fe\u7247\u4e0a\u4f20\u5931\u8d25", true);
                return;
            }
            QLog.e("ExtendFriendNewEditFragment", 1, "uploadTask cancel");
        }
    };
    private IphonePickerView.PickerViewAdapter E0 = new i();
    private IphonePickerView.PickerViewAdapter F0 = new j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements a.InterfaceC8324a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IphonePickerView f263693a;

        b(IphonePickerView iphonePickerView) {
            this.f263693a = iphonePickerView;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.a.InterfaceC8324a
        public void onBackPressed() {
            ExtendFriendNewEditFragment.this.Vh(this.f263693a.getSelection(0), this.f263693a.getSelection(1), this.f263693a.getSelection(2));
            ExtendFriendNewEditFragment.this.f263675r0.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IphonePickerView f263695d;

        c(IphonePickerView iphonePickerView) {
            this.f263695d = iphonePickerView;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            ExtendFriendNewEditFragment.this.Vh(this.f263695d.getSelection(0), this.f263695d.getSelection(1), this.f263695d.getSelection(2));
            ExtendFriendNewEditFragment.this.f263675r0.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExtendFriendNewEditFragment.this.ci(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class g implements ConditionSearchManager.c {
        g() {
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            ExtendFriendNewEditFragment.this.dismissWaitingDialog();
            if (!z16) {
                ExtendFriendNewEditFragment.this.Ai(1, "\u83b7\u53d6\u5730\u533a\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002", true);
            } else if (ExtendFriendNewEditFragment.this.isVisible() && i3 == 2) {
                ExtendFriendNewEditFragment.this.Ci();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class h extends TransProcessorHandler {
        h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            int i3 = message.what;
            if (i3 != 1003) {
                if (i3 != 1005) {
                    return;
                }
                int i16 = fileMsg.fileType;
                if (i16 == 67) {
                    QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo fail");
                    ExtendFriendNewEditFragment.this.Ai(1, "\u56fe\u7247\u4e0a\u4f20\u5931\u8d25", true);
                    return;
                } else {
                    if (i16 == 68) {
                        QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload avatar fail");
                        ExtendFriendNewEditFragment.this.Ai(1, "\u5934\u50cf\u4e0a\u4f20\u5931\u8d25", true);
                        return;
                    }
                    return;
                }
            }
            int i17 = fileMsg.fileType;
            if (i17 != 67) {
                if (i17 == 68) {
                    QLog.d("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload avatar success");
                    ExtendFriendNewEditFragment.this.M.f264178a = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mUrl;
                    ExtendFriendNewEditFragment.this.xi();
                    return;
                }
                return;
            }
            String str = ((NearbyPeoplePhotoUploadProcessor) fileMsg.processor).mUrl;
            if (ExtendFriendNewEditFragment.this.J != null && ExtendFriendNewEditFragment.this.K >= 0 && ExtendFriendNewEditFragment.this.J.size() > ExtendFriendNewEditFragment.this.K) {
                QLog.d("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo success");
                ((PhotoWallListView.a) ExtendFriendNewEditFragment.this.J.get(ExtendFriendNewEditFragment.this.K)).f264178a = str;
                ExtendFriendNewEditFragment.this.Ii();
                return;
            }
            QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo cancel");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class k implements IphonePickerView.IphonePickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IphonePickerView f263704a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqexpand.widget.a f263705b;

        k(IphonePickerView iphonePickerView, com.tencent.mobileqq.qqexpand.widget.a aVar) {
            this.f263704a = iphonePickerView;
            this.f263705b = aVar;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            com.tencent.mobileqq.qqexpand.widget.a aVar = this.f263705b;
            if (aVar == null || !aVar.isShowing()) {
                return;
            }
            ExtendFriendNewEditFragment.this.f263674q0.setClickable(true);
            this.f263705b.dismiss();
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            int selection = this.f263704a.getSelection(0);
            ExtendFriendNewEditFragment extendFriendNewEditFragment = ExtendFriendNewEditFragment.this;
            extendFriendNewEditFragment.yi(extendFriendNewEditFragment.f263666i0, ExtendFriendNewEditFragment.this.E0.getText(0, selection));
            ExtendFriendNewEditFragment.this.f263666i0.setTag(Integer.valueOf(selection));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class l implements a.InterfaceC8324a {
        l() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.a.InterfaceC8324a
        public void onBackPressed() {
            ExtendFriendNewEditFragment.this.f263674q0.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class m implements ActionSheet.OnDismissListener {
        m() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            ExtendFriendNewEditFragment.this.f263674q0.setClickable(true);
        }
    }

    private void Bi(final String str) {
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.10
            @Override // java.lang.Runnable
            public void run() {
                if (ExtendFriendNewEditFragment.this.C.isFinishing()) {
                    return;
                }
                if (ExtendFriendNewEditFragment.this.F == null) {
                    ExtendFriendNewEditFragment.this.F = new QQProgressDialog(ExtendFriendNewEditFragment.this.C, ExtendFriendNewEditFragment.this.C.getTitleBarHeight());
                }
                ExtendFriendNewEditFragment.this.F.setMessage(str);
                if (ExtendFriendNewEditFragment.this.C.isFinishing()) {
                    return;
                }
                ExtendFriendNewEditFragment.this.F.show();
            }
        });
    }

    private void Di() {
        this.I.j();
        this.H.setText(String.format("(%d/4)", Integer.valueOf(this.J.size())));
    }

    private void Fi() {
        if (TextUtils.isEmpty(this.W)) {
            this.R.setText("\u4ecb\u7ecd\u4e00\u4e0b\u81ea\u5df1\u7684\u7279\u957f\u3001\u5174\u8da3\u7231\u597d\u3001\u4ea4\u53cb\u76ee\u7684");
        } else {
            this.R.setText(this.W);
        }
    }

    private void Gi() {
        if (Wh()) {
            try {
                this.f263681x0.setData(new JSONObject(this.f263664g0));
                this.f263680w0.setVisibility(0);
                return;
            } catch (JSONException e16) {
                QLog.d("ExtendFriendNewEditFragment", 1, e16.toString());
            }
        }
        this.f263680w0.setVisibility(8);
    }

    private void Hi() {
        PhotoWallListView.a aVar = this.M;
        if (aVar != null && TextUtils.isEmpty(aVar.f264178a) && !TextUtils.isEmpty(this.M.f264179b)) {
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mIsUp = true;
            transferRequest.mSelfUin = this.E.getCurrentUin();
            transferRequest.mLocalPath = this.M.f264179b;
            transferRequest.mUniseq = System.currentTimeMillis();
            transferRequest.mFileType = 68;
            Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
            commFileExtReq.uint32_action_type.set(0);
            commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(si() + "-" + pi(this.M.f264179b) + ".jpg"));
            transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
            ((ITransFileController) this.E.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
            return;
        }
        QLog.d("ExtendFriendNewEditFragment", 1, "uploadAvatar mAvatarPath is null or already upload");
        xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        if (bi() >= 0) {
            this.E.execute(this.D0);
        } else {
            Hi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(int i3, int i16, int i17) {
        int i18 = i3 + 1896;
        int i19 = this.f263668k0 - i18;
        Calendar calendar = Calendar.getInstance();
        int i26 = i16 + 1;
        int i27 = i17 + 1;
        calendar.set(1, i26, i27);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, this.f263669l0, this.f263670m0);
        if (calendar.after(calendar2)) {
            i19--;
        }
        if (i19 < 0) {
            i19 = 0;
        }
        String t16 = Utils.t(i26, i27);
        this.f263662e0 = t16;
        int S2 = AgeSelectionActivity.S2(t16);
        yi(this.f263667j0, hi(i18, i26, i27, this.f263662e0));
        this.f263667j0.setTag(new Object[]{Integer.valueOf((i18 << 16) | (i26 << 8) | i27), Integer.valueOf(i19), Integer.valueOf(S2)});
    }

    private boolean Wh() {
        if (!TextUtils.isEmpty(this.f263664g0)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.f263664g0).optJSONObject(QQPermissionConstants.Permission.AUIDO_GROUP);
                if (optJSONObject == null) {
                    return false;
                }
                return optJSONObject.optInt("grade") > 0;
            } catch (JSONException e16) {
                QLog.d("ExtendFriendNewEditFragment", 1, e16.toString());
            }
        }
        return false;
    }

    private void Xh() {
        int i3;
        int i16;
        if (Zh(this.X, getNick())) {
            this.S = true;
            return;
        }
        if (this.Y != getGender()) {
            this.S = true;
            return;
        }
        Object[] objArr = (Object[]) this.f263667j0.getTag();
        if (objArr != null && objArr.length > 0) {
            int i17 = 0;
            int intValue = ((Integer) objArr[0]).intValue();
            if (intValue != 0) {
                i17 = intValue >>> 16;
                i16 = (65280 & intValue) >>> 8;
                i3 = intValue & 255;
            } else {
                i3 = 0;
                i16 = 0;
            }
            if (this.f263658a0 != i17 || this.f263659b0 != i16 || this.f263660c0 != i3) {
                this.S = true;
                return;
            }
        } else if (this.f263658a0 != 0 || this.f263659b0 != 0 || this.f263660c0 != 0) {
            this.S = true;
            return;
        }
        if (Zh(this.f263663f0, ki())) {
            this.S = true;
        }
    }

    private void Yh(String str, String str2, int i3) {
        if (Zh(this.W, str)) {
            this.U = true;
        }
    }

    private boolean Zh(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return !str.equals(str2);
    }

    private void ai(String[] strArr) {
        String str;
        try {
            str = this.G.O(strArr);
        } catch (Exception e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
            str = null;
        }
        if (str == null || str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
            str = "";
        }
        if (this.f263677t0 == null || TextUtils.isEmpty(str)) {
            return;
        }
        yi(this.f263677t0, str);
        this.f263677t0.setTag(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaitingDialog() {
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.11
            @Override // java.lang.Runnable
            public void run() {
                if (ExtendFriendNewEditFragment.this.F == null || !ExtendFriendNewEditFragment.this.F.isShowing() || ExtendFriendNewEditFragment.this.C.isFinishing()) {
                    return;
                }
                ExtendFriendNewEditFragment.this.F.dismiss();
            }
        });
    }

    private String ei() {
        return this.f263661d0;
    }

    private String fi(int i3) {
        String str = new String[]{"", "60\u540e", "70\u540e", "80\u540e", "90\u540e", "00\u540e", "10\u540e", "10\u540e"}[i3 >= 1960 ? ((i3 - 1960) / 10) + 1 : 0];
        this.f263661d0 = str;
        return str;
    }

    private int getAge() {
        Object[] objArr = (Object[]) this.f263667j0.getTag();
        if (objArr == null || objArr.length < 2) {
            return 0;
        }
        return ((Integer) objArr[1]).intValue();
    }

    private String getAvatar() {
        PhotoWallListView.a aVar = this.M;
        if (aVar != null) {
            return aVar.f264178a;
        }
        return "";
    }

    private int getGender() {
        int intValue = ((Integer) this.f263666i0.getTag()).intValue();
        if (intValue < 0 || intValue > 1) {
            return 0;
        }
        return intValue + 1;
    }

    private String getNick() {
        return this.f263665h0.getText().toString();
    }

    private String gi() {
        int intValue;
        Object[] objArr = (Object[]) this.f263667j0.getTag();
        if (objArr == null || objArr.length < 3 || (intValue = ((Integer) objArr[0]).intValue()) == 0) {
            return "";
        }
        return hi(intValue >>> 16, (65280 & intValue) >>> 8, intValue & 255, this.f263662e0);
    }

    private String hi(int i3, int i16, int i17, String str) {
        String fi5 = fi(i3);
        StringBuilder sb5 = new StringBuilder();
        if (TextUtils.isEmpty(fi5)) {
            sb5.append(i3);
            sb5.append("-");
            sb5.append(i16);
            sb5.append("-");
            sb5.append(i17);
            sb5.append(" ");
            sb5.append(str);
        } else {
            sb5.append(fi5);
            sb5.append("-");
            sb5.append(str);
        }
        return sb5.toString();
    }

    private JSONObject ii() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("nick", getNick());
            jSONObject.putOpt("age", Integer.valueOf(getAge()));
            jSONObject.putOpt(LpReport_UserInfo_dc02148.CONSTELLATION, li());
            jSONObject.putOpt("gender", Integer.valueOf(getGender()));
            jSONObject.putOpt("birthday", ji());
            jSONObject.putOpt("self_birthday", ji());
            jSONObject.putOpt("age_group", ei());
            jSONObject.putOpt("city", ki());
            jSONObject.putOpt("location", oi());
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUI() {
        Di();
        Fi();
        Ei();
        Gi();
        yi(this.f263665h0, this.X);
        yi(this.f263666i0, this.E0.getText(0, this.Y - 1));
        yi(this.f263667j0, gi());
        yi(this.f263677t0, this.f263663f0);
    }

    private JSONObject ji() {
        int i3;
        int i16;
        int i17;
        int intValue;
        JSONObject jSONObject = new JSONObject();
        Object[] objArr = (Object[]) this.f263667j0.getTag();
        if (objArr == null || objArr.length <= 0 || (intValue = ((Integer) objArr[0]).intValue()) == 0) {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        } else {
            i16 = intValue >>> 16;
            i17 = (65280 & intValue) >>> 8;
            i3 = intValue & 255;
        }
        try {
            jSONObject.putOpt("year", Integer.valueOf(i16));
            jSONObject.putOpt("month", Integer.valueOf(i17));
            jSONObject.putOpt("day", Integer.valueOf(i3));
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    private String ki() {
        String O = this.G.O((String[]) this.f263677t0.getTag());
        return (TextUtils.isEmpty(O) || IProfileCardConst.NAME_NO_LIMIT.equals(O)) ? this.f263663f0 : O;
    }

    private String li() {
        Object[] objArr = (Object[]) this.f263667j0.getTag();
        if (objArr != null && objArr.length >= 3) {
            return Utils.s(((Integer) objArr[2]).intValue());
        }
        return "";
    }

    private JSONObject mi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("declarationa", this.W);
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    private JSONObject oi() {
        int i3;
        int i16;
        int i17;
        int i18;
        String[] strArr = (String[]) this.f263677t0.getTag();
        if (strArr == null || strArr.length < 4) {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        } else {
            i16 = ProfileCodecUtils.encodeLocCode(strArr[0]);
            i17 = ProfileCodecUtils.encodeLocCode(strArr[1]);
            i18 = ProfileCodecUtils.encodeLocCode(strArr[2]);
            i3 = ProfileCodecUtils.encodeLocCode(strArr[3]);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("country", Integer.valueOf(i16));
            jSONObject.putOpt("province", Integer.valueOf(i17));
            jSONObject.putOpt("city", Integer.valueOf(i18));
            jSONObject.putOpt("district", Integer.valueOf(i3));
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    private void onClickAge() {
        com.tencent.mobileqq.qqexpand.widget.a n06 = com.tencent.mobileqq.qqexpand.widget.a.n0(this.C);
        Calendar calendar = Calendar.getInstance();
        this.f263668k0 = calendar.get(1);
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) n06.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.C).inflate(R.layout.avo, (ViewGroup) null);
        iphonePickerView.initialize(this.F0);
        if (this.f263667j0.getTag() != null) {
            int intValue = ((Integer) ((Object[]) this.f263667j0.getTag())[0]).intValue();
            if (intValue == 0) {
                this.f263671n0 = 94;
                this.f263672o0 = 0;
                this.f263673p0 = 0;
            } else {
                this.f263671n0 = (intValue >>> 16) - 1896;
                this.f263672o0 = ((65280 & intValue) >>> 8) - 1;
                this.f263673p0 = (intValue & 255) - 1;
            }
            calendar.setTimeInMillis(System.currentTimeMillis());
            this.f263668k0 = calendar.get(1);
            this.f263669l0 = calendar.get(2) + 1;
            this.f263670m0 = calendar.get(5);
            iphonePickerView.setPickListener(new a(iphonePickerView, n06));
            n06.o0(new b(iphonePickerView));
            n06.setOnDismissListener(new c(iphonePickerView));
            this.f263675r0.setClickable(false);
            iphonePickerView.setSelection(0, this.f263671n0);
            iphonePickerView.setSelection(1, this.f263672o0);
            iphonePickerView.setSelection(2, this.f263673p0);
            n06.setActionContentView(iphonePickerView, null);
            n06.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String pi(String str) {
        FileInputStream fileInputStream;
        byte[] hexStr2Bytes;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        r4 = null;
        r4 = null;
        byte[] bArr = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    hexStr2Bytes = MD5.toMD5Byte(fileInputStream, file.length());
                } catch (UnsatisfiedLinkError unused) {
                    if (file.exists()) {
                        String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                        if (d16 == null) {
                            d16 = "";
                        }
                        hexStr2Bytes = HexUtil.hexStr2Bytes(d16);
                    }
                }
                bArr = hexStr2Bytes;
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    QLog.e("ExtendFriendNewEditFragment", 1, e17, new Object[0]);
                }
            } catch (IOException e18) {
                e = e18;
                QLog.e("ExtendFriendNewEditFragment", 1, e, new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        QLog.e("ExtendFriendNewEditFragment", 1, e19, new Object[0]);
                    }
                }
                return HexUtil.bytes2HexStr(bArr);
            }
            return HexUtil.bytes2HexStr(bArr);
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e26) {
                    QLog.e("ExtendFriendNewEditFragment", 1, e26, new Object[0]);
                }
            }
            throw th;
        }
    }

    private JSONObject qi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("base_info", ii());
            jSONObject.putOpt("avatar", getAvatar());
            jSONObject.putOpt("expand_info", mi());
            jSONObject.putOpt("pictures_wall_urls", ri());
            jSONObject.putOpt("wangzhe_record", new JSONObject(this.f263664g0));
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    private JSONObject ri() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < this.J.size(); i3++) {
                jSONArray.put(i3, this.J.get(i3).f264178a);
            }
            jSONObject.putOpt("pictures_wall_pic", jSONArray);
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int si() {
        return new Random().nextInt(90000000) + 10000000;
    }

    private JSONObject ti() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("infos", qi());
        } catch (JSONException e16) {
            QLog.e("ExtendFriendNewEditFragment", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    private void ui() {
        com.tencent.mobileqq.qqexpand.widget.a n06 = com.tencent.mobileqq.qqexpand.widget.a.n0(this.C);
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) n06.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.C).inflate(R.layout.avo, (ViewGroup) null);
        iphonePickerView.initialize(this.E0);
        if (this.f263666i0.getTag() != null) {
            int intValue = ((Integer) this.f263666i0.getTag()).intValue();
            if (intValue < 0 || intValue > 1) {
                intValue = 0;
            }
            iphonePickerView.setSelection(0, intValue);
            iphonePickerView.setPickListener(new k(iphonePickerView, n06));
            n06.o0(new l());
            n06.setOnDismissListener(new m());
            this.f263674q0.setClickable(false);
            n06.setActionContentView(iphonePickerView, null);
            n06.show();
        }
    }

    private void vi() {
        Intent intent = new Intent();
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo();
        extendFriendInfo.f263491d = this.W;
        intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
        QPublicFragmentActivity.startForResult(this.C, intent, (Class<? extends QPublicBaseFragment>) ExpandEditFragment.class, 5003);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        try {
            QLog.d("ExtendFriendNewEditFragment", 1, "parseExtendFriendInfo:" + this.f263682y0);
            JSONObject jSONObject = new JSONObject(this.f263682y0).getJSONObject("infos");
            this.M = new PhotoWallListView.a(jSONObject.optString("avatar"), null);
            JSONObject optJSONObject = jSONObject.optJSONObject("wangzhe_record");
            if (optJSONObject != null) {
                this.f263664g0 = optJSONObject.toString();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("expand_info");
            if (optJSONObject2 != null) {
                this.W = optJSONObject2.optString("declarationa");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pictures_wall_urls");
            if (optJSONObject3 != null) {
                JSONArray optJSONArray = optJSONObject3.optJSONArray("pictures_wall_pic");
                if (optJSONArray != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(optJSONArray.getString(i3));
                    }
                    this.I.i(arrayList);
                } else {
                    this.I.i(null);
                }
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("base_info");
            this.X = jSONObject2.optString("nick");
            int optInt = jSONObject2.optInt("gender");
            this.Y = optInt;
            this.f263666i0.setTag(Integer.valueOf(optInt - 1));
            this.Z = jSONObject2.optInt("age");
            this.f263661d0 = jSONObject2.optString("age_group");
            String optString = jSONObject2.optString(LpReport_UserInfo_dc02148.CONSTELLATION);
            this.f263662e0 = optString;
            int S2 = AgeSelectionActivity.S2(optString);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("self_birthday");
            this.f263658a0 = jSONObject3.optInt("year");
            this.f263659b0 = jSONObject3.optInt("month");
            int optInt2 = jSONObject3.optInt("day");
            this.f263660c0 = optInt2;
            this.f263667j0.setTag(new Object[]{Integer.valueOf(optInt2 | (this.f263658a0 << 16) | (this.f263659b0 << 8)), Integer.valueOf(this.Z), Integer.valueOf(S2)});
            this.f263663f0 = jSONObject2.optString("city");
            if (jSONObject2.optJSONObject("location") != null) {
                this.f263677t0.setTag(new String[]{ProfileCodecUtils.decodeRemoteCode(r4.optInt("country")), ProfileCodecUtils.decodeRemoteCode(r4.optInt("province")), ProfileCodecUtils.decodeRemoteCode(r4.optInt("city")), ProfileCodecUtils.decodeRemoteCode(r4.optInt("district"))});
            } else {
                this.f263677t0.setTag(new String[]{"0", "0", "0", "0"});
            }
        } catch (JSONException e16) {
            Ai(1, "\u6570\u636e\u83b7\u53d6\u53d1\u751f\u5f02\u5e38", true);
            QLog.e("ExtendFriendNewEditFragment", 1, "parseExtendFriendInfo exception", e16);
        }
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.19
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendNewEditFragment.this.dismissWaitingDialog();
                ExtendFriendNewEditFragment.this.initUI();
            }
        });
    }

    private void zi() {
        DialogUtil.createCustomDialog(this.C, 0, (String) null, "\u8fd4\u56de\u4f1a\u4e22\u5931\u5f53\u524d\u7f16\u8f91\u5185\u5bb9\uff0c\u662f\u5426\u8fd4\u56de\uff1f", "\u53d6\u6d88", "\u786e\u5b9a", new d(), new e()).show();
    }

    public void Ai(final int i3, final String str, final boolean z16) {
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    ExtendFriendNewEditFragment.this.dismissWaitingDialog();
                }
                QQToast.makeText(ExtendFriendNewEditFragment.this.C, i3, str, 0).show();
            }
        });
    }

    public void Ci() {
        Intent intent = new Intent(this.C, (Class<?>) LocationSelectActivity.class);
        intent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, "\u57ce\u5e02");
        int j3 = this.G.j();
        if (j3 != 0) {
            int h06 = this.G.h0(j3, true);
            if (h06 == 2) {
                Ai(1, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002", false);
                return;
            } else {
                if (h06 == 0) {
                    Bi(this.C.getResources().getString(R.string.a8f));
                    this.G.g(this.B0);
                    return;
                }
                return;
            }
        }
        String[] strArr = (String[]) this.f263677t0.getTag();
        if (strArr == null || strArr.length != 4) {
            strArr = new String[]{"0", "0", "0", "0"};
        }
        intent.putExtra(IProfileCardConst.PARAM_LOCATION_CODE, strArr);
        intent.putExtra("param_is_popup", false);
        intent.putExtra("param_location_param", this.G.O(strArr));
        this.C.startActivityForResult(intent, 5002);
    }

    public void ni() {
        ILimitChatUtils iLimitChatUtils = (ILimitChatUtils) QRoute.api(ILimitChatUtils.class);
        QQAppInterface qQAppInterface = this.E;
        iLimitChatUtils.preLoadDataForArkMiniProfileCard(qQAppInterface, Long.valueOf(Long.parseLong(qQAppInterface.getCurrentUin())), new f());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null) {
            QLog.e("ExtendFriendNewEditFragment", 1, "onActivityResult bundle is null");
            return;
        }
        if (i3 == 10020) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("PhotoConst.SELECTED_PATHS");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                this.V = true;
            }
            this.I.a(stringArrayList);
            Di();
            return;
        }
        if (i3 != 10021) {
            switch (i3) {
                case 5001:
                    ArrayList<String> stringArrayList2 = extras.getStringArrayList(TroopAvatarWallPreviewActivity.KEY_EXTEND_FRIEND_DELETE_PATH_LIST);
                    if (stringArrayList2 != null && stringArrayList2.size() > 0) {
                        this.V = true;
                    }
                    this.I.b(stringArrayList2);
                    Di();
                    return;
                case 5002:
                    ai(intent.getStringArrayExtra(IProfileCardConst.PARAM_LOCATION_CODE));
                    return;
                case 5003:
                    ExtendFriendInfo extendFriendInfo = (ExtendFriendInfo) extras.getParcelable(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO);
                    if (extendFriendInfo != null) {
                        Yh(extendFriendInfo.f263491d, extendFriendInfo.f263494h, extendFriendInfo.f263495i);
                        this.W = extendFriendInfo.f263491d;
                        Fi();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        String string = extras.getString("PhotoConst.SINGLE_PHOTO_PATH");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.T = true;
        this.M = new PhotoWallListView.a(null, string);
        Ei();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Xh();
        if (!this.S && !this.T && !this.U && !this.V) {
            ci(false);
            return true;
        }
        zi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oyc /* 1912930306 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#birthday_btn", true, -1L, -1L, null, true, true);
                onClickAge();
                return;
            case R.id.oyg /* 1912930310 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#profile_photo_btn", true, -1L, -1L, null, true, true);
                di(true);
                return;
            case R.id.oyj /* 1912930313 */:
                onBackEvent();
                return;
            case R.id.oyq /* 1912930320 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#city_btn", true, -1L, -1L, null, true, true);
                Ci();
                return;
            case R.id.oyz /* 1912930329 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#dating_profile_btn", true, -1L, -1L, null, true, true);
                vi();
                return;
            case R.id.ozm /* 1912930353 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#sex_btn", true, -1L, -1L, null, true, true);
                ui();
                return;
            case R.id.p0i /* 1912930386 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#name_btn", true, -1L, -1L, null, true, true);
                di(false);
                return;
            case R.id.p1g /* 1912930421 */:
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#save_btn", true, -1L, -1L, null, true, true);
                if (!NetworkState.isNetworkConnected(this.C)) {
                    Ai(1, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002", false);
                    return;
                } else {
                    if (TextUtils.isEmpty(getNick())) {
                        Ai(1, "\u6635\u79f0\u4e0d\u80fd\u4e3a\u7a7a", false);
                        return;
                    }
                    Xh();
                    Bi("\u6b63\u5728\u4fdd\u5b58");
                    Ii();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = getQBaseActivity();
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.E = qQAppInterface;
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) qQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        this.G = conditionSearchManager;
        conditionSearchManager.h(this);
        this.C0.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ((ITransFileController) this.E.getRuntimeService(ITransFileController.class)).addHandle(this.C0);
        Intent intent = this.C.getIntent();
        if (intent != null) {
            this.f263682y0 = intent.getStringExtra("key_extend_friend_info_json");
        }
        Window window = this.C.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#edit_data_page#view", true, -1L, -1L, null, true, true);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ConditionSearchManager conditionSearchManager = this.G;
        if (conditionSearchManager != null) {
            conditionSearchManager.S(this.B0);
            this.G.o(this);
        }
        ((ITransFileController) this.E.getRuntimeService(ITransFileController.class)).removeHandle(this.C0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class f extends ExpandObserver {
        f() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void p(boolean z16, Object obj) {
            if (z16) {
                ExtendFriendNewEditFragment.this.dismissWaitingDialog();
                ExtendFriendNewEditFragment.this.f263682y0 = (String) obj;
                ExtendFriendNewEditFragment.this.wi();
                return;
            }
            ExtendFriendNewEditFragment.this.Ai(1, "\u83b7\u53d6\u4e2a\u4eba\u4fe1\u606f\u5931\u8d25", false);
            ExtendFriendNewEditFragment.this.ci(false);
        }
    }

    private int bi() {
        this.K = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= this.J.size()) {
                break;
            }
            if (this.J.get(i3).c()) {
                this.K = i3;
                break;
            }
            i3++;
        }
        return this.K;
    }

    private void Ei() {
        PhotoWallListView.a aVar = this.M;
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.f264179b)) {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final Bitmap bitmap = null;
                        try {
                            File file = new File(ExtendFriendNewEditFragment.this.M.f264179b);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, ExtendFriendNewEditFragment.this.L.getWidth(), ExtendFriendNewEditFragment.this.L.getHeight());
                            bufferedInputStream.close();
                            bitmap = com.tencent.mobileqq.util.j.d(ExtendFriendNewEditFragment.this.M.f264179b, options);
                            if (bitmap != null) {
                                bitmap = QQAppInterface.getCircleFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
                            }
                        } catch (Exception e16) {
                            QLog.d("ExtendFriendNewEditFragment", 1, e16.toString());
                        }
                        if (bitmap != null) {
                            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ExtendFriendNewEditFragment.this.L.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                });
                return;
            }
            if (TextUtils.isEmpty(this.M.f264178a)) {
                return;
            }
            QQAppInterface qQAppInterface = this.E;
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, qQAppInterface.getCurrentUin());
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = this.L.getWidth();
            obtain.mRequestHeight = this.L.getHeight();
            obtain.mFailedDrawable = faceDrawable;
            obtain.mLoadingDrawable = faceDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(this.M.f264178a, obtain);
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
            drawable.setTag(new int[]{640, 640});
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendNewEditFragment", 2, "onGetHDHeadUrl: newDisplayHDHead");
            }
            DynamicAvatarView dynamicAvatarView = this.L;
            QQAppInterface qQAppInterface2 = this.E;
            dynamicAvatarView.setFaceDrawable(qQAppInterface2, drawable, 1, 200, qQAppInterface2.getCurrentUin(), 640, true, null, false, true, false, true, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z16) {
        if (z16) {
            this.f263682y0 = ti().toString();
            if (this.C.getIntent() != null && this.f263682y0 != null) {
                ExtendFriendCardOnHeadIconClick.W.put(this.E.getCurrentUin(), this.f263682y0);
            }
        } else {
            this.C.setResult(0);
        }
        this.C.finish();
    }

    private void di(boolean z16) {
        if (z16) {
            Ai(0, "\u8be5\u5934\u50cf\u4e3aQQ\u5934\u50cf\uff0c\u8bf7\u524d\u5f80QQ\u8d44\u6599\u5361\u8fdb\u884c\u4fee\u6539", false);
        } else {
            Ai(0, "\u8be5\u6635\u79f0\u4e3aQQ\u6635\u79f0\uff0c\u8bf7\u524d\u5f80QQ\u8d44\u6599\u5361\u8fdb\u884c\u4fee\u6539", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.czx, viewGroup, false);
        this.D = inflate;
        this.H = (TextView) inflate.findViewById(R.id.p0p);
        PhotoWallListView photoWallListView = (PhotoWallListView) this.D.findViewById(R.id.p0o);
        this.I = photoWallListView;
        photoWallListView.setActivity(this.C);
        this.I.setPhotoPathList(this.J);
        this.N = (ImageView) this.D.findViewById(R.id.oyj);
        this.P = (TextView) this.D.findViewById(R.id.p1g);
        this.Q = (ImageView) this.D.findViewById(R.id.oyz);
        this.R = (TextView) this.D.findViewById(R.id.f163224oz3);
        this.L = (DynamicAvatarView) this.D.findViewById(R.id.oyg);
        EditText editText = (EditText) this.D.findViewById(R.id.p0i);
        this.f263665h0 = editText;
        n nVar = new n(36, editText);
        this.f263679v0 = nVar;
        this.f263665h0.addTextChangedListener(nVar);
        this.f263666i0 = (TextView) this.D.findViewById(R.id.ozk);
        this.f263667j0 = (TextView) this.D.findViewById(R.id.oyb);
        this.f263677t0 = (TextView) this.D.findViewById(R.id.oyp);
        this.f263680w0 = this.D.findViewById(R.id.p2l);
        this.f263681x0 = (ExtendFriendHonorOfKingRecordView) this.D.findViewById(R.id.ozh);
        this.f263674q0 = this.D.findViewById(R.id.ozm);
        this.f263675r0 = this.D.findViewById(R.id.oyc);
        this.f263676s0 = this.D.findViewById(R.id.oyq);
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.f263665h0.setOnClickListener(this);
        this.f263674q0.setOnClickListener(this);
        this.f263675r0.setOnClickListener(this);
        this.f263676s0.setOnClickListener(this);
        this.f263666i0.setTag(0);
        this.f263667j0.setTag(new Object[]{0, 0, 0});
        this.f263677t0.setTag(new String[]{"0", "0", "0", "0"});
        if (TextUtils.isEmpty(this.f263682y0)) {
            ni();
            Bi("\u6b63\u5728\u83b7\u53d6\u6570\u636e");
        } else {
            wi();
        }
        return this.D;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class j implements IphonePickerView.PickerViewAdapter {
        j() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            if (i3 == 0) {
                return (i16 + 1896) + HardCodeUtil.qqStr(R.string.oig);
            }
            if (i3 == 1) {
                return (i16 + 1) + HardCodeUtil.qqStr(R.string.ol9);
            }
            if (i3 != 2) {
                return "";
            }
            return (i16 + 1) + HardCodeUtil.qqStr(R.string.okr);
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            if (i3 == 0) {
                return (ExtendFriendNewEditFragment.this.f263668k0 - 1896) + 1;
            }
            if (i3 == 1) {
                if (ExtendFriendNewEditFragment.this.f263671n0 + 1896 == ExtendFriendNewEditFragment.this.f263668k0) {
                    return ExtendFriendNewEditFragment.this.f263669l0;
                }
                return 12;
            }
            if (i3 != 2) {
                return 0;
            }
            if (ExtendFriendNewEditFragment.this.f263671n0 + 1896 == ExtendFriendNewEditFragment.this.f263668k0 && ExtendFriendNewEditFragment.this.f263672o0 + 1 == ExtendFriendNewEditFragment.this.f263669l0) {
                return ExtendFriendNewEditFragment.this.f263670m0;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, ExtendFriendNewEditFragment.this.f263671n0 + 1896);
            calendar.set(2, ExtendFriendNewEditFragment.this.f263672o0);
            calendar.set(5, 1);
            return calendar.getActualMaximum(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements IphonePickerView.IphonePickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IphonePickerView f263690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqexpand.widget.a f263691b;

        a(IphonePickerView iphonePickerView, com.tencent.mobileqq.qqexpand.widget.a aVar) {
            this.f263690a = iphonePickerView;
            this.f263691b = aVar;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            com.tencent.mobileqq.qqexpand.widget.a aVar = this.f263691b;
            if (aVar == null || !aVar.isShowing()) {
                return;
            }
            ExtendFriendNewEditFragment.this.Vh(this.f263690a.getSelection(0), this.f263690a.getSelection(1), this.f263690a.getSelection(2));
            ExtendFriendNewEditFragment.this.f263675r0.setClickable(true);
            this.f263691b.dismiss();
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                ExtendFriendNewEditFragment.this.f263671n0 = i16;
            } else if (i3 == 1) {
                ExtendFriendNewEditFragment.this.f263672o0 = i16;
            } else if (i3 == 2) {
                ExtendFriendNewEditFragment.this.f263673p0 = i16;
            }
            IphonePickerView iphonePickerView = this.f263690a;
            if (iphonePickerView != null) {
                if (i3 == 0 || i3 == 1) {
                    iphonePickerView.notifyDataSetChange(1);
                    this.f263690a.notifyDataSetChange(2);
                }
                ExtendFriendNewEditFragment.this.Vh(this.f263690a.getSelection(0), this.f263690a.getSelection(1), this.f263690a.getSelection(2));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class i implements IphonePickerView.PickerViewAdapter {
        i() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            return 2;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            if (i16 < 0 || i16 > 1) {
                i16 = 0;
            }
            if (i16 == 0) {
                return HardCodeUtil.qqStr(R.string.oje);
            }
            return HardCodeUtil.qqStr(R.string.oim);
        }
    }

    public void xi() {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private class n implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f263709d;

        /* renamed from: e, reason: collision with root package name */
        private EditText f263710e;

        /* renamed from: f, reason: collision with root package name */
        private int f263711f;

        /* renamed from: h, reason: collision with root package name */
        private int f263712h;

        public n(int i3, EditText editText) {
            this.f263709d = i3;
            this.f263710e = editText;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable editable) {
            String str;
            Throwable th5;
            String str2;
            String substring;
            String str3 = "";
            String obj = this.f263710e.getText().toString();
            if (obj.getBytes().length <= this.f263709d) {
                return;
            }
            if (ExtendFriendNewEditFragment.this.f263678u0 == null) {
                ExtendFriendNewEditFragment extendFriendNewEditFragment = ExtendFriendNewEditFragment.this;
                extendFriendNewEditFragment.f263678u0 = QQToast.makeText(extendFriendNewEditFragment.C, "\u6635\u79f0\u4e0d\u80fd\u8fc7\u957f", 0);
            }
            if (!ExtendFriendNewEditFragment.this.f263678u0.isShowing()) {
                ExtendFriendNewEditFragment.this.f263678u0.show();
            }
            try {
                substring = obj.substring(0, this.f263711f);
            } catch (Throwable th6) {
                th = th6;
                str = "";
            }
            try {
                str = obj.substring(this.f263711f + this.f263712h, obj.length());
                try {
                    int i3 = this.f263711f;
                    str3 = obj.substring(i3, this.f263712h + i3);
                    if (substring.getBytes().length + str.getBytes().length <= this.f263709d) {
                        while (obj.getBytes().length > this.f263709d && str3.length() > 0) {
                            str3 = str3.substring(0, str3.length() - 1);
                            obj = substring + str3 + str;
                        }
                        this.f263710e.setText(obj);
                        this.f263710e.setSelection(substring.length() + str3.length());
                    }
                } catch (Throwable th7) {
                    str2 = str3;
                    str3 = substring;
                    th5 = th7;
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                str = "";
                str3 = substring;
                th5 = th;
                str2 = str;
                if (QLog.isColorLevel()) {
                    return;
                }
                QLog.d("ExtendFriendNewEditFragment", 2, "afterTextChanged, headStr:" + str3 + ", tailStr = " + str + ", insert = " + str2, th5);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f263711f = i3;
            this.f263712h = i17;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
