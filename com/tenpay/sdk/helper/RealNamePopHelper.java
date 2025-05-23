package com.tenpay.sdk.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tenpay.QwLog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.IResult;
import com.tenpay.sdk.activity.ParentInfoCollectActivity;
import com.tenpay.sdk.activity.TenpayUtilActivity;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.FakeUrlHandler;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
/* loaded from: classes27.dex */
public class RealNamePopHelper {
    public static final int POP_TYPE_AGE_16TO18 = 2;
    public static final int POP_TYPE_AGE_18PLUS = 3;
    public static final int POP_TYPE_AGE_8TO16 = 4;
    public static final int POP_TYPE_REJECT = 1;
    private TenpayUtilActivity mUtilActivity;
    private boolean mRenamePopEnabled = true;
    private HashMap<String, String> parentParams = new HashMap<>();

    /* loaded from: classes27.dex */
    public interface RealNamePopListener {
        public static final int CODE_AGREED = 2;
        public static final int CODE_NON_AGE = 0;
        public static final int CODE_PARENT_AGREEMENT = 4;
        public static final int CODE_REJECT = 1;
        public static final int CODE_UNABLED = 3;

        void onPoped(int i3, int i16);
    }

    public RealNamePopHelper(TenpayUtilActivity tenpayUtilActivity) {
        this.mUtilActivity = tenpayUtilActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUploadData(String str) {
        TenpayUtilActivity tenpayUtilActivity = this.mUtilActivity;
        if (tenpayUtilActivity instanceof TenpayUtilActivity) {
            tenpayUtilActivity.addUploadData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void childParentAtSideTip(final int i3, final RealNamePopListener realNamePopListener) {
        new FakeUrlHandler(this.mUtilActivity.getActivity()).handle((String) null, JSONConstant.sRealNameParentConfirmTip.replace(RedTouch.NEWLINE_CHAR, "\n"), new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.5
            @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
            public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex btnIndex, @Nullable Uri uri) {
                if (btnIndex == FakeUrlDialogBuilder.BtnIndex.RIGHT) {
                    RealNamePopHelper.this.addUploadData("guardian.opinion.agreement");
                    realNamePopListener.onPoped(i3, 4);
                } else {
                    RealNamePopHelper.this.addUploadData("guardian.opinion.disagreement");
                    realNamePopListener.onPoped(i3, 1);
                }
                return true;
            }
        });
        addUploadData("guardian.opinion.show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return this.mUtilActivity.getContext();
    }

    public static boolean isNeedPop(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 4 || i3 == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popAgeLimit(final int i3, final RealNamePopListener realNamePopListener) {
        FakeUrlHandler fakeUrlHandler = new FakeUrlHandler(this.mUtilActivity.getActivity());
        if (i3 == 1) {
            fakeUrlHandler.handle((String) null, JSONConstant.sRealNameNonAgeBelow8Default.replace(RedTouch.NEWLINE_CHAR, "\n"), new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.2
                @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex btnIndex, @Nullable Uri uri) {
                    realNamePopListener.onPoped(i3, 0);
                    return true;
                }
            });
        } else if (i3 == 4) {
            fakeUrlHandler.handle((String) null, JSONConstant.sRealNameChildAgeTip.replace(RedTouch.NEWLINE_CHAR, "\n"), new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.3
                @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex btnIndex, @Nullable Uri uri) {
                    if (btnIndex == FakeUrlDialogBuilder.BtnIndex.RIGHT) {
                        RealNamePopHelper.this.addUploadData("guardian.side.beside");
                        RealNamePopHelper.this.childParentAtSideTip(i3, realNamePopListener);
                        return true;
                    }
                    return true;
                }
            });
            addUploadData("guardian.side.show");
        } else {
            fakeUrlHandler.handle((String) null, JSONConstant.sRealNameNonAgeAfter8Default.replace(RedTouch.NEWLINE_CHAR, "\n"), new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.4
                @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex btnIndex, @Nullable Uri uri) {
                    int i16;
                    RealNamePopListener realNamePopListener2 = realNamePopListener;
                    int i17 = i3;
                    if (btnIndex == FakeUrlDialogBuilder.BtnIndex.RIGHT) {
                        i16 = 2;
                    } else {
                        i16 = 1;
                    }
                    realNamePopListener2.onPoped(i17, i16);
                    return true;
                }
            });
        }
    }

    private void popPrivacy(final int i3, final RealNamePopListener realNamePopListener) {
        QwLog.i("popType: " + i3);
        new FakeUrlHandler(this.mUtilActivity.getActivity()).handle((String) null, JSONConstant.sRealNamePrivacyNotesDefault.replace(RedTouch.NEWLINE_CHAR, "\n"), new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.1
            @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
            public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex btnIndex, @Nullable Uri uri) {
                if (btnIndex == FakeUrlDialogBuilder.BtnIndex.RIGHT) {
                    int i16 = i3;
                    if (i16 != 3) {
                        RealNamePopHelper.this.popAgeLimit(i16, realNamePopListener);
                    } else {
                        realNamePopListener.onPoped(i16, 2);
                    }
                } else {
                    realNamePopListener.onPoped(i3, 1);
                }
                return true;
            }
        });
    }

    public HashMap<String, String> getParentParams() {
        return this.parentParams;
    }

    public void pros8to14ChildParentInfoLogic(final String str) {
        Intent intent = new Intent();
        intent.putExtra("params", getParentParams());
        intent.putExtra("cre_id", str);
        this.mUtilActivity.startActivityForResult(intent, ParentInfoCollectActivity.class, new IResult() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.6
            @Override // com.tenpay.sdk.IResult
            public void back(int i3, Intent intent2) {
                if (i3 == -1) {
                    RealNamePopHelper.this.setParentParams((HashMap) intent2.getSerializableExtra("params"));
                    QUIProxy.createCustomDialog(RealNamePopHelper.this.mUtilActivity.getContext(), 230, null, RealNamePopHelper.this.getContext().getString(R.string.f1795239l), RealNamePopHelper.this.getContext().getString(R.string.f1795339m), RealNamePopHelper.this.getContext().getString(R.string.dvt), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.RealNamePopHelper.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("params", RealNamePopHelper.this.getParentParams());
                            intent3.putExtra("cre_id", str);
                            RealNamePopHelper.this.mUtilActivity.startActivityForResult(intent3, ParentInfoCollectActivity.class, this);
                        }
                    });
                }
            }
        });
    }

    public void resetParentParams() {
        this.parentParams.clear();
    }

    public void setParentParams(Map<String, String> map) {
        this.parentParams.clear();
        if (map != null) {
            this.parentParams.putAll(map);
        }
    }

    public void tryPop(int i3, RealNamePopListener realNamePopListener) {
        this.mRenamePopEnabled = true;
        popPrivacy(i3, realNamePopListener);
    }

    public void tryPopByCreditIdFromIdVerify(String str, RealNamePopListener realNamePopListener) {
        int ageByIDNumber = Utils.getAgeByIDNumber(str);
        if (ageByIDNumber < 8 && ageByIDNumber >= 0) {
            popAgeLimit(1, realNamePopListener);
            return;
        }
        if (ageByIDNumber >= 8 && ageByIDNumber <= 16) {
            if (this.parentParams.size() > 0) {
                realNamePopListener.onPoped(4, 2);
                return;
            } else {
                popAgeLimit(4, realNamePopListener);
                return;
            }
        }
        if (ageByIDNumber > 8 && ageByIDNumber < 18) {
            popAgeLimit(2, realNamePopListener);
        } else {
            realNamePopListener.onPoped(3, 2);
        }
    }
}
