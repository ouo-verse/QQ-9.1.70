package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.cw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import com.tencent.qqnt.aio.msg.api.IAIOMsgRecordApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionBatchForwardOption extends ForwardPhotoOption {
    static IPatchRedirector $redirector_;
    ArrayList<String> G;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionBatchForwardOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQCustomDialog qQCustomDialog = EmotionBatchForwardOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    EmotionBatchForwardOption emotionBatchForwardOption = EmotionBatchForwardOption.this;
                    emotionBatchForwardOption.R(emotionBatchForwardOption.G);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public EmotionBatchForwardOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("FAV_PATH_OR_ID");
        this.G = stringArrayListExtra;
        if (stringArrayListExtra == null) {
            this.G = new ArrayList<>();
        }
    }

    private List<MsgRecord> O(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        String string = this.mExtraData.getString("uin");
        String string2 = this.mExtraData.getString("troop_uin");
        int i3 = this.mExtraData.getInt("uintype");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = string;
        sessionInfo.f179559f = string2;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String Q = Q(next);
            if ("MARK_EMOTION:".equals(Q)) {
                String[] split = next.substring(next.indexOf(":") + 1).split("_&_");
                if (split.length >= 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionBatchForwardOption", 2, "forwardOnConfirm epId:" + split[0] + ",eId:" + split[1]);
                    }
                    IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.app.getRuntimeService(IEmoticonManagerService.class);
                    Emoticon syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(String.valueOf(split[0]), split[1]);
                    EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(syncFindEmoticonById.epId);
                    if (syncFindEmoticonPackageById != null) {
                        arrayList2.add(((IAIOMsgRecordApi) QRoute.api(IAIOMsgRecordApi.class)).getMarkFaceMsgRecord(ChatActivityFacade.g0(this.app, syncFindEmoticonPackageById, syncFindEmoticonById)));
                    }
                }
            } else if ("PIC_EMOTION:".equals(Q)) {
                String[] split2 = next.substring(next.indexOf(":") + 1).split("_&_");
                if (split2.length >= 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionBatchForwardOption", 2, "[generateNtMsgRecord]:  path:" + split2[0] + ", md5:" + split2[1]);
                    }
                    MsgRecord picMsgRecord = ((IAIOMsgRecordApi) QRoute.api(IAIOMsgRecordApi.class)).getPicMsgRecord(split2[0], null, true, 1, null, null);
                    if (picMsgRecord != null) {
                        arrayList2.add(picMsgRecord);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String P(EmoticonInfo emoticonInfo) {
        StringBuilder sb5 = new StringBuilder();
        if (emoticonInfo instanceof IPicEmoticonInfo) {
            Emoticon emoticon = ((IPicEmoticonInfo) emoticonInfo).getEmoticon();
            if (emoticon != null) {
                sb5.append("MARK_EMOTION:");
                sb5.append(emoticon.epId);
                sb5.append("_&_");
                sb5.append(emoticon.eId);
            }
        } else if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
            sb5.append("PIC_EMOTION:");
            sb5.append(((IFavoriteEmoticonInfo) emoticonInfo).getPath());
            sb5.append("_&_");
            if (emoticonInfo instanceof FavoriteEmoticonInfo) {
                sb5.append(((FavoriteEmoticonInfo) emoticonInfo).emojiMd5);
            }
        }
        return sb5.toString();
    }

    public static String Q(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            return str.substring(0, indexOf + 1);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(final ArrayList<String> arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.forward.c
            @Override // java.lang.Runnable
            public final void run() {
                EmotionBatchForwardOption.this.T(arrayList);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(List list) {
        boolean z16;
        if (!this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            QQCustomDialog qQCustomDialog = this.mConfirmDialog;
            if (qQCustomDialog instanceof cw) {
                z16 = ((cw) qQCustomDialog).X();
            } else {
                z16 = false;
            }
            ((IMsgForwardNtUtil) QRoute.api(IMsgForwardNtUtil.class)).previewMsgWithMsgRecord(this.mActivity, 0, "", MobileQQ.sMobileQQ.getResources().getString(R.string.f172196o92), list, false, -1, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(ArrayList arrayList) {
        final List<MsgRecord> O = O(arrayList);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.forward.d
            @Override // java.lang.Runnable
            public final void run() {
                EmotionBatchForwardOption.this.S(O);
            }
        });
    }

    public static void U(Activity activity, List<EmoticonInfo> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<EmoticonInfo> it = list.iterator();
        while (it.hasNext()) {
            String P = P(it.next());
            if (!P.equals("") && !arrayList.contains(P)) {
                arrayList.add(P);
                if (QLog.isColorLevel()) {
                    QLog.d("EmotionBatchForwardOption", 2, "launchFriendPicker \uff1a" + P);
                }
            }
        }
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtras(new Bundle());
        intent.putExtra("forward_type", 47);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT_NEED_FINISH, true);
        intent.putStringArrayListExtra("FAV_PATH_OR_ID", arrayList);
        intent.putExtra("k_dataline", false);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.forward.ForwardPhotoOption, com.tencent.mobileqq.forward.ForwardBaseOption
    protected View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String format = String.format(this.mActivity.getString(R.string.zux), "" + this.G.size());
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        EllipsizingTextView ellipsizingTextView = new EllipsizingTextView(this.mActivity, null);
        ellipsizingTextView.setText(new QQText(format, 3, 16));
        ellipsizingTextView.setMaxLines(2);
        ellipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        ellipsizingTextView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.f157084jf));
        ellipsizingTextView.setTextSize(14.0f);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 17;
        linearLayout.addView(ellipsizingTextView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(14.0f));
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(ViewUtils.dip2px(3.0f), 0, 0, 0);
        SimpleModeHelper.s(ellipsizingTextView, imageView, layoutParams2);
        linearLayout.addView(imageView, layoutParams2);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        View view = new View(this.mActivity);
        SimpleModeHelper.q(view);
        view.setOnClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.forward.ForwardPhotoOption, com.tencent.mobileqq.forward.ForwardBaseOption
    protected void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.forward.EmotionBatchForwardOption.2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.forward.EmotionBatchForwardOption$2$a */
                /* loaded from: classes12.dex */
                class a implements QueryCallback<Emoticon> {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ SessionInfo f210544a;

                    a(SessionInfo sessionInfo) {
                        this.f210544a = sessionInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) sessionInfo);
                        }
                    }

                    @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void postQuery(Emoticon emoticon) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticon);
                        } else {
                            EmotionBatchForwardOption emotionBatchForwardOption = EmotionBatchForwardOption.this;
                            ChatActivityFacade.R0(emotionBatchForwardOption.app, emotionBatchForwardOption.mAppContext, this.f210544a, emoticon, null);
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmotionBatchForwardOption.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String string = EmotionBatchForwardOption.this.mExtraData.getString("uin");
                    String string2 = EmotionBatchForwardOption.this.mExtraData.getString("troop_uin");
                    int i3 = EmotionBatchForwardOption.this.mExtraData.getInt("uintype");
                    SessionInfo sessionInfo = new SessionInfo();
                    sessionInfo.f179555d = i3;
                    sessionInfo.f179557e = string;
                    sessionInfo.f179559f = string2;
                    String userInputStr = EmotionBatchForwardOption.this.getUserInputStr();
                    if (userInputStr != null && !userInputStr.equals("")) {
                        com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, userInputStr);
                    }
                    Iterator<String> it = EmotionBatchForwardOption.this.G.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        String Q = EmotionBatchForwardOption.Q(next);
                        if ("MARK_EMOTION:".equals(Q)) {
                            String[] split = next.substring(next.indexOf(":") + 1).split("_&_");
                            if (split.length >= 2) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("EmotionBatchForwardOption", 2, "forwardOnConfirm epId:" + split[0] + ",eId:" + split[1]);
                                }
                                ((IEmoticonManagerService) EmotionBatchForwardOption.this.app.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(split[0]), split[1], new a(sessionInfo));
                            }
                        } else if ("PIC_EMOTION:".equals(Q)) {
                            String[] split2 = next.substring(next.indexOf(":") + 1).split("_&_");
                            Bundle bundle = new Bundle();
                            if (split2.length >= 2) {
                                str = split2[1];
                                bundle.putString("filemd5", str);
                            } else {
                                str = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("EmotionBatchForwardOption", 2, "forwardOnConfirm  path:" + split2[0] + ", md5:" + str);
                            }
                            EmotionBatchForwardOption emotionBatchForwardOption = EmotionBatchForwardOption.this;
                            ChatActivityFacade.F0(emotionBatchForwardOption.app, emotionBatchForwardOption.mAppContext, sessionInfo, split2[0], false, "", bundle);
                        }
                    }
                }
            });
        }
    }
}
