package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes12.dex */
public class EmotionPreviewFragment extends PublicBaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, IPreviewThumbAdapter.IThumbItemClickListener {
    static IPatchRedirector $redirector_ = null;
    public static final String PREVIEW_DATA = "preview_data";
    private static final String TAG = "EmotionPreviewFragment";
    private TextView leftText;
    private EmotionPreviewAdapter mAdapter;
    private EmotionGallery mGallery;
    private IPreviewThumbAdapter mThumbAdapter;
    private NumberCheckBox numberCheckBox;
    private ArrayList<EmotionPreviewInfo> previewDataList;
    private RelativeLayout rightView;
    private HorizontalListView selectedPhotoListView;
    private Button sendButton;
    private RelativeLayout titleBar;
    private TextView titleText;
    private View topLineView;

    public EmotionPreviewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void back() {
        Intent intent = getBaseActivity().getIntent();
        intent.setClass(getBaseActivity(), NewPhotoListActivity.class);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mThumbAdapter.getDataList());
        intent.addFlags(603979776);
        startActivity(intent);
        getBaseActivity().finish();
    }

    public static void enterEmotionPreview(Activity activity, Intent intent, ArrayList<String> arrayList) {
        if (arrayList != null && intent != null) {
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                EmotionPreviewInfo emotionPreviewInfo = new EmotionPreviewInfo();
                emotionPreviewInfo.path = next;
                emotionPreviewInfo.isCheck = true;
                arrayList2.add(emotionPreviewInfo);
            }
            intent.putParcelableArrayListExtra(PREVIEW_DATA, arrayList2);
            PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 10015);
        }
    }

    private int getPositionByPath(String str) {
        ArrayList<EmotionPreviewInfo> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.previewDataList) != null && arrayList.size() > 0) {
            int size = this.previewDataList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.previewDataList.get(i3).path.equals(str)) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    private int getSelectItemCount() {
        ArrayList<EmotionPreviewInfo> arrayList = this.previewDataList;
        int i3 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<EmotionPreviewInfo> it = this.previewDataList.iterator();
            while (it.hasNext()) {
                if (it.next().isCheck) {
                    i3++;
                }
            }
        }
        return i3;
    }

    private void initData() {
        ArrayList<EmotionPreviewInfo> parcelableArrayListExtra = getBaseActivity().getIntent().getParcelableArrayListExtra(PREVIEW_DATA);
        this.previewDataList = parcelableArrayListExtra;
        this.mAdapter.refreshData(parcelableArrayListExtra);
        ArrayList<EmotionPreviewInfo> arrayList = this.previewDataList;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<String> arrayList2 = new ArrayList<>(this.previewDataList.size());
            Iterator<EmotionPreviewInfo> it = this.previewDataList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().path);
            }
            IPreviewThumbAdapter createPreviewThumbAdapter = ((IEmotionPreviewService) QRoute.api(IEmotionPreviewService.class)).createPreviewThumbAdapter(getBaseActivity(), this);
            this.mThumbAdapter = createPreviewThumbAdapter;
            this.selectedPhotoListView.setAdapter((ListAdapter) createPreviewThumbAdapter);
            this.selectedPhotoListView.setVisibility(0);
            this.selectedPhotoListView.setOnItemClickListener(this.mThumbAdapter);
            this.selectedPhotoListView.setDividerWidth(BaseAIOUtils.f(14.0f, getResources()));
            this.mThumbAdapter.setData(arrayList2);
            this.mThumbAdapter.setCurrentPath(this.previewDataList.get(0).path);
        }
        refreshSendButton();
        refreshTitleView(1);
        refreshNumberCheckBox(0, 0);
    }

    private void refreshNumberCheckBox(int i3, int i16) {
        ArrayList<EmotionPreviewInfo> arrayList;
        if (this.numberCheckBox != null && (arrayList = this.previewDataList) != null) {
            EmotionPreviewInfo emotionPreviewInfo = arrayList.get(i3);
            this.numberCheckBox.setChecked(emotionPreviewInfo.isCheck);
            if (emotionPreviewInfo.isCheck && i16 >= 0) {
                this.numberCheckBox.setCheckedNumber(i16 + 1);
            }
        }
    }

    private void refreshSendButton() {
        if (this.sendButton != null) {
            int selectItemCount = getSelectItemCount();
            StringBuffer stringBuffer = new StringBuffer(getResources().getString(R.string.cvf));
            if (selectItemCount < 1) {
                this.sendButton.setText(stringBuffer.toString());
                return;
            }
            Button button = this.sendButton;
            stringBuffer.append("(");
            stringBuffer.append(selectItemCount);
            stringBuffer.append(")");
            button.setText(stringBuffer.toString());
        }
    }

    private void refreshTitleView(int i3) {
        ArrayList<EmotionPreviewInfo> arrayList;
        if (this.titleText != null && (arrayList = this.previewDataList) != null && arrayList.size() > 1) {
            TextView textView = this.titleText;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i3);
            stringBuffer.append("/");
            stringBuffer.append(this.previewDataList.size());
            textView.setText(stringBuffer.toString());
        }
    }

    public View generateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.c7z, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initTitleBar(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        this.leftText = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.titleText = (TextView) view.findViewById(R.id.ivTitleName);
        this.rightView = (RelativeLayout) view.findViewById(R.id.im5);
        this.numberCheckBox = (NumberCheckBox) view.findViewById(R.id.iml);
        this.leftText.setOnClickListener(this);
        this.rightView.setOnClickListener(this);
    }

    protected void initViewWithBusiness(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        Button button = (Button) view.findViewById(R.id.send_btn);
        this.sendButton = button;
        button.setOnClickListener(this);
        this.topLineView = view.findViewById(R.id.li9);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jo9);
        this.titleBar = relativeLayout;
        ((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
        this.mGallery = (EmotionGallery) view.findViewById(R.id.gallery);
        EmotionPreviewAdapter emotionPreviewAdapter = new EmotionPreviewAdapter(getBaseActivity());
        this.mAdapter = emotionPreviewAdapter;
        this.mGallery.setAdapter((SpinnerAdapter) emotionPreviewAdapter);
        this.mGallery.setSpacing(getBaseActivity().getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.mGallery.setOnItemSelectedListener(this);
        this.mGallery.setOnNoBlankListener(this.mAdapter);
        this.mGallery.enableDoubleTap(false);
        this.mGallery.enableScaleGesture(false);
        this.selectedPhotoListView = (HorizontalListView) view.findViewById(R.id.li_);
        initData();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        back();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                back();
            } else if (id5 == R.id.im5) {
                int selectedItemPosition = this.mGallery.getSelectedItemPosition();
                ArrayList<EmotionPreviewInfo> arrayList = this.previewDataList;
                if (arrayList != null && selectedItemPosition < arrayList.size()) {
                    EmotionPreviewInfo emotionPreviewInfo = this.previewDataList.get(selectedItemPosition);
                    boolean z16 = !emotionPreviewInfo.isCheck;
                    emotionPreviewInfo.isCheck = z16;
                    this.numberCheckBox.setChecked(z16);
                    refreshSendButton();
                    IPreviewThumbAdapter iPreviewThumbAdapter = this.mThumbAdapter;
                    if (iPreviewThumbAdapter != null) {
                        iPreviewThumbAdapter.setCurrentPath(emotionPreviewInfo.path);
                        ArrayList<String> dataList = this.mThumbAdapter.getDataList();
                        if (emotionPreviewInfo.isCheck) {
                            dataList.add(emotionPreviewInfo.path);
                            try {
                                refreshNumberCheckBox(selectedItemPosition, dataList.indexOf(emotionPreviewInfo.path));
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "onClick exception = " + e16.getMessage());
                                }
                            }
                        } else {
                            dataList.remove(emotionPreviewInfo.path);
                        }
                        if (dataList.size() == 0) {
                            this.topLineView.setVisibility(8);
                            this.selectedPhotoListView.setVisibility(8);
                        } else {
                            this.topLineView.setVisibility(0);
                            this.selectedPhotoListView.setVisibility(0);
                        }
                        this.mThumbAdapter.setData(dataList);
                    }
                }
            } else if (id5 == R.id.send_btn) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                IPreviewThumbAdapter iPreviewThumbAdapter2 = this.mThumbAdapter;
                if (iPreviewThumbAdapter2 != null) {
                    arrayList2 = iPreviewThumbAdapter2.getDataList();
                }
                if (arrayList2.size() == 0) {
                    int selectedItemPosition2 = this.mGallery.getSelectedItemPosition();
                    ArrayList<EmotionPreviewInfo> arrayList3 = this.previewDataList;
                    if (arrayList3 != null && selectedItemPosition2 < arrayList3.size()) {
                        EmotionPreviewInfo emotionPreviewInfo2 = this.previewDataList.get(selectedItemPosition2);
                        if (!TextUtils.isEmpty(emotionPreviewInfo2.path)) {
                            arrayList2.add(emotionPreviewInfo2.path);
                        }
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(arrayList2.size()), "", "", "");
                Intent intent = new Intent();
                intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList2);
                getBaseActivity().setResult(-1, intent);
                getBaseActivity().finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View generateRootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            generateRootView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            generateRootView = generateRootView(layoutInflater, viewGroup);
            initTitleBar(generateRootView);
            initViewWithBusiness(generateRootView);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, generateRootView);
        return generateRootView;
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        ArrayList<EmotionPreviewInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (this.mThumbAdapter != null && (arrayList = this.previewDataList) != null && i3 < arrayList.size()) {
            EmotionPreviewInfo emotionPreviewInfo = this.previewDataList.get(i3);
            boolean z16 = !emotionPreviewInfo.path.equals(this.mThumbAdapter.getCurrentPath());
            this.mThumbAdapter.setCurrentPath(emotionPreviewInfo.path);
            if (z16) {
                this.mThumbAdapter.notifyDataSetChanged();
            }
            ArrayList<String> dataList = this.mThumbAdapter.getDataList();
            if (dataList != null && !TextUtils.isEmpty(emotionPreviewInfo.path)) {
                int indexOf = dataList.indexOf(emotionPreviewInfo.path);
                if (indexOf >= 0) {
                    refreshNumberCheckBox(i3, indexOf);
                } else {
                    refreshNumberCheckBox(i3, -1);
                }
            }
        }
        refreshTitleView(i3 + 1);
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) adapterView);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter.IThumbItemClickListener
    public void onThumbClick(int i3) {
        ArrayList<String> dataList;
        int positionByPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        IPreviewThumbAdapter iPreviewThumbAdapter = this.mThumbAdapter;
        if (iPreviewThumbAdapter != null && (dataList = iPreviewThumbAdapter.getDataList()) != null && i3 < dataList.size() && (positionByPath = getPositionByPath(dataList.get(i3))) >= 0) {
            EmotionGallery emotionGallery = this.mGallery;
            if (emotionGallery != null) {
                emotionGallery.setSelection(positionByPath);
            }
            refreshTitleView(positionByPath + 1);
            refreshNumberCheckBox(positionByPath, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
