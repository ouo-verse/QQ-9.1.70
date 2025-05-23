package com.tencent.biz.pubaccount.readinjoySearch;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.i;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ReadInJoyNewSearchActivity extends BaseActivity implements View.OnClickListener, i.a {

    /* renamed from: a0, reason: collision with root package name */
    private Button f79879a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f79880b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageButton f79881c0;

    /* renamed from: d0, reason: collision with root package name */
    private EditText f79882d0;

    /* renamed from: e0, reason: collision with root package name */
    private XListView f79883e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f79884f0;

    /* renamed from: g0, reason: collision with root package name */
    private i f79885g0;

    /* renamed from: h0, reason: collision with root package name */
    protected Handler f79886h0 = new a();

    /* renamed from: i0, reason: collision with root package name */
    private TextWatcher f79887i0 = new b();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                ReadInJoyNewSearchActivity.this.N2((List) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            String trim = ReadInJoyNewSearchActivity.this.f79882d0.getText().toString().trim();
            if (66 == i3 && keyEvent.getAction() == 0 && !TextUtils.isEmpty(trim)) {
                InputMethodManager inputMethodManager = (InputMethodManager) ReadInJoyNewSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(ReadInJoyNewSearchActivity.this.f79882d0.getWindowToken(), 2);
                }
                ReadInJoyNewSearchActivity.this.K2(trim);
                ReadInJoyNewSearchActivity.this.M2(trim);
                return false;
            }
            return false;
        }
    }

    private void J2() {
        this.f79885g0 = new i(this, null, this);
        XListView xListView = (XListView) super.findViewById(R.id.ijs);
        this.f79883e0 = xListView;
        xListView.setAdapter((ListAdapter) this.f79885g0);
        this.f79884f0 = super.findViewById(R.id.iju);
        L2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(String str) {
        String c16;
        try {
            String encode = Uri.encode(str.trim());
            y52.a config = ((IReadInJoySearchJumpUrlConfProcessor) QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig();
            if (config == null) {
                c16 = "";
            } else {
                c16 = config.c();
            }
            if (c16 != null) {
                if (c16.contains("$KEYWORD$")) {
                    c16 = c16.replace("$KEYWORD$", encode);
                }
            } else {
                c16 = "https://so.mp.qq.com/search/index?key=" + encode + "&_wv=3&_bid=2321";
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyNewSearchActivity", 2, "jumpToHotWord(). jumpUrl=" + c16);
            }
            Intent intent = new Intent(this, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
            intent.putExtra("url", c16);
            startActivity(intent);
            String decode = Uri.decode(encode);
            if (decode.contains("|")) {
                decode = decode.replaceAll("\\|", " ");
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80067C4", "0X80067C4", 0, 0, "", "", decode, "", false);
        } catch (Exception unused) {
        }
    }

    private void L2() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.4
            @Override // java.lang.Runnable
            public void run() {
                EntityManager createEntityManager = ReadInJoyNewSearchActivity.this.app.getEntityManagerFactory().createEntityManager();
                List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
                Message obtainMessage = ReadInJoyNewSearchActivity.this.f79886h0.obtainMessage(1);
                obtainMessage.obj = query;
                ReadInJoyNewSearchActivity.this.f79886h0.sendMessage(obtainMessage);
                createEntityManager.close();
                if (query != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyNewSearchActivity", 2, "lookupHistory size: " + query.size());
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyNewSearchActivity", 2, "history is null");
                }
            }
        }, 10, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(List<ReadInJoySearchHistoryEntity> list) {
        if (list != null && list.size() != 0) {
            this.f79884f0.setVisibility(0);
            this.f79884f0.setFocusable(false);
            this.f79883e0.setVisibility(0);
            this.f79883e0.setFocusable(false);
        } else {
            this.f79884f0.setVisibility(8);
        }
        this.f79885g0.b(list);
    }

    @TargetApi(14)
    private void initViews() {
        this.f79880b0 = super.findViewById(R.id.root);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            this.f79880b0.setFitsSystemWindows(true);
        }
        Button button = (Button) super.findViewById(R.id.btn_cancel_search);
        this.f79879a0 = button;
        button.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) super.findViewById(R.id.ib_clear_text);
        this.f79881c0 = imageButton;
        imageButton.setOnClickListener(this);
        EditText editText = (EditText) super.findViewById(R.id.et_search_keyword);
        this.f79882d0 = editText;
        editText.requestFocus();
        this.f79882d0.addTextChangedListener(this.f79887i0);
        this.f79882d0.setImeOptions(3);
        this.f79882d0.setOnKeyListener(new c());
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.i.a
    public void D2(ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity) {
        this.f79882d0.setText(readInJoySearchHistoryEntity.keyWord);
        if (!TextUtils.isEmpty(readInJoySearchHistoryEntity.keyWord)) {
            EditText editText = this.f79882d0;
            editText.setSelection(editText.getText().length());
        }
        K2(readInJoySearchHistoryEntity.keyWord);
        M2(readInJoySearchHistoryEntity.keyWord);
        String trim = readInJoySearchHistoryEntity.keyWord.trim();
        if (trim.contains("|")) {
            trim = trim.replaceAll("\\|", " ");
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8006819", "0X8006819", 0, 0, trim, "", "", "", false);
    }

    public void M2(final String str) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity;
                EntityManager createEntityManager = ReadInJoyNewSearchActivity.this.app.getEntityManagerFactory().createEntityManager();
                List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
                if (query != null) {
                    Iterator<? extends Entity> it = query.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            readInJoySearchHistoryEntity = (ReadInJoySearchHistoryEntity) it.next();
                            if (readInJoySearchHistoryEntity.keyWord.equals(str)) {
                                createEntityManager.remove(readInJoySearchHistoryEntity);
                                break;
                            }
                        } else {
                            readInJoySearchHistoryEntity = null;
                            break;
                        }
                    }
                    if (readInJoySearchHistoryEntity != null) {
                        query.remove(readInJoySearchHistoryEntity);
                    }
                    if (query.size() == 20) {
                        createEntityManager.remove(query.get(query.size() - 1));
                        query.remove(query.size() - 1);
                    }
                } else {
                    new ArrayList();
                }
                ReadInJoySearchHistoryEntity readInJoySearchHistoryEntity2 = new ReadInJoySearchHistoryEntity();
                readInJoySearchHistoryEntity2.keyWord = str;
                readInJoySearchHistoryEntity2.timestamp = System.currentTimeMillis();
                createEntityManager.persist(readInJoySearchHistoryEntity2);
                createEntityManager.close();
            }
        }, 10, null, true);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        super.setContentView(R.layout.a_e);
        initViews();
        J2();
        if (VersionUtils.isIceScreamSandwich()) {
            getWindow().setFlags(16777216, 16777216);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        TextWatcher textWatcher = this.f79887i0;
        if (textWatcher != null) {
            this.f79882d0.removeTextChangedListener(textWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        L2();
        EditText editText = this.f79882d0;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.i.a
    public void k1() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EntityManager createEntityManager = ReadInJoyNewSearchActivity.this.app.getEntityManagerFactory().createEntityManager();
                                List<? extends Entity> query = createEntityManager.query(ReadInJoySearchHistoryEntity.class);
                                if (query == null) {
                                    return;
                                }
                                Iterator<? extends Entity> it = query.iterator();
                                while (it.hasNext()) {
                                    createEntityManager.remove((ReadInJoySearchHistoryEntity) it.next());
                                }
                                query.clear();
                                Message obtainMessage = ReadInJoyNewSearchActivity.this.f79886h0.obtainMessage(1);
                                obtainMessage.obj = query;
                                ReadInJoyNewSearchActivity.this.f79886h0.sendMessage(obtainMessage);
                                createEntityManager.close();
                            }
                        }, 10, null, true);
                        return;
                    }
                    return;
                }
                dialogInterface.dismiss();
            }
        };
        createCustomDialog.setPositiveButton(R.string.f171271dn1, onClickListener);
        createCustomDialog.setNegativeButton(R.string.f171270dn0, onClickListener);
        String string = getString(R.string.f171272dn2);
        createCustomDialog.setTitle(R.string.f171377ej4);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setTextColor(getResources().getColor(R.color.f156931fl));
        textView.setText(string);
        textView.setGravity(1);
        createCustomDialog.addView(textView);
        createCustomDialog.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.btn_cancel_search) {
            finish();
        } else if (id5 == R.id.ib_clear_text) {
            this.f79882d0.setText("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(ReadInJoyNewSearchActivity.this.f79882d0.getText().toString())) {
                ReadInJoyNewSearchActivity.this.f79881c0.setVisibility(8);
            } else {
                ReadInJoyNewSearchActivity.this.f79881c0.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
