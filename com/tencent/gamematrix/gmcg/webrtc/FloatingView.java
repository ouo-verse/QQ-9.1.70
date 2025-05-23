package com.tencent.gamematrix.gmcg.webrtc;

import android.R;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatingView extends FrameLayout {
    private EditText editTextSharp;
    private Context mContext;
    private WindowManager.LayoutParams mParams;
    private View mView;
    private FloatingManager mWindowManager;
    Timer recTimer;
    int rec_lookback_ms;
    int rec_time_ms;
    private WebRTCSDK sdk;
    private SeekBar seekSharp;
    private Spinner spinnerRecordLookback;
    private Spinner spinnerRecordTimer;
    private Switch switchFilter;
    private Switch switchRtpRecord;

    /* compiled from: P */
    /* renamed from: com.tencent.gamematrix.gmcg.webrtc.FloatingView$6, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass6 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass6() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            int MethodCall;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (FloatingView.this.sdk != null) {
                if (z16) {
                    FloatingView.this.rec_lookback_ms = Integer.parseInt(FloatingView.this.spinnerRecordLookback.getSelectedItem().toString()) * 1000;
                    FloatingView.this.rec_time_ms = Integer.parseInt(FloatingView.this.spinnerRecordTimer.getSelectedItem().toString()) * 1000;
                    FloatingView floatingView = FloatingView.this;
                    if (floatingView.rec_time_ms < 0) {
                        floatingView.rec_time_ms = -1;
                    }
                    str = "StartRtpRecord";
                    MethodCall = FloatingView.this.sdk.MethodCall("StartRtpRecord", new LinkedList<String>() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.6.1
                        {
                            add("0");
                            add(String.valueOf(FloatingView.this.rec_lookback_ms));
                            add("-1");
                        }
                    });
                    FloatingView floatingView2 = FloatingView.this;
                    if (floatingView2.rec_lookback_ms > 0) {
                        floatingView2.recTimer = new BaseTimer();
                        FloatingView.this.recTimer.schedule(new TimerTask() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.6.2
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                Log.v("VideoFilter", "2 timer   switch: " + FloatingView.this.switchRtpRecord.isChecked());
                                if (FloatingView.this.switchRtpRecord.isChecked()) {
                                    Log.v("VideoFilter", "3 timer   switch: " + FloatingView.this.switchRtpRecord.isChecked());
                                    FloatingView.this.switchRtpRecord.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.6.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FloatingView.this.switchRtpRecord.setChecked(false);
                                        }
                                    });
                                }
                            }
                        }, r4.rec_time_ms);
                        Log.v("VideoFilter", "1 timer   switch: " + FloatingView.this.switchRtpRecord.isChecked() + " rec_time_ms:" + FloatingView.this.rec_time_ms);
                    }
                } else {
                    Timer timer = FloatingView.this.recTimer;
                    if (timer != null) {
                        timer.cancel();
                        FloatingView.this.recTimer = null;
                    }
                    Log.v("VideoFilter", "4 timer   switch: " + FloatingView.this.switchRtpRecord.isChecked());
                    str = "StopRtpRecord";
                    MethodCall = FloatingView.this.sdk.MethodCall("StopRtpRecord", new LinkedList<String>() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.6.3
                        {
                            add("0");
                        }
                    });
                }
                Log.v("VideoFilter", " MethodCall :" + str + " res:" + MethodCall);
                Context context = FloatingView.this.mContext;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("MethodCall\uff1a");
                sb5.append(str);
                sb5.append("(");
                String str2 = " ";
                if (z16) {
                    str2 = String.valueOf(FloatingView.this.rec_lookback_ms) + " " + String.valueOf(FloatingView.this.rec_time_ms);
                }
                sb5.append(str2);
                sb5.append(") res:");
                sb5.append(MethodCall);
                Toast.makeText(context, sb5.toString(), 0).show();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public FloatingView(Context context) {
        super(context);
        this.recTimer = null;
        this.rec_lookback_ms = 10000;
        this.rec_time_ms = 10000;
        this.sdk = null;
        this.mContext = context.getApplicationContext();
        this.mView = LayoutInflater.from(context).inflate(R.layout.filter_floating_view, (ViewGroup) null);
        Log.v("VideoFilter", "0 switch filter:  last:" + VideoFilterController.get().isOpenTvesr() + " fac:" + VideoFilterController.get().getTvsrSharpFactor());
        Switch r06 = (Switch) this.mView.findViewById(R.id.switchFilter);
        this.switchFilter = r06;
        r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                Log.v("VideoFilter", "1 switch filter: " + z16 + " last:" + VideoFilterController.get().isOpenTvesr() + " fac:" + VideoFilterController.get().getTvsrSharpFactor());
                VideoFilterController.get().setOpenTvesr(z16);
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        });
        EditText editText = (EditText) this.mView.findViewById(R.id.editTextSharp);
        this.editTextSharp = editText;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.2
            private float last_fac = -1.0f;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                boolean z16;
                if (charSequence.toString().isEmpty()) {
                    return;
                }
                float floatValue = Float.valueOf(charSequence.toString()).floatValue();
                boolean z17 = true;
                if (floatValue < 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (floatValue <= 3.0f) {
                    z17 = false;
                }
                if (z16 | z17) {
                    Toast.makeText(FloatingView.this.mContext, " \u8bf7\u8f93\u5165\u6b63\u786e\u6570\u503c:0.0~3.0", 0).show();
                    return;
                }
                if (this.last_fac < 0.0f) {
                    this.last_fac = floatValue;
                }
                if (Math.abs(this.last_fac - floatValue) < 0.1d) {
                    return;
                }
                this.last_fac = floatValue;
                FloatingView.this.seekSharp.setProgress((int) ((floatValue * 255.0f) / 3.0f));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        SeekBar seekBar = (SeekBar) this.mView.findViewById(R.id.SeekBarSharp);
        this.seekSharp = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.3
            private float last_fac = -1.0f;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i3, boolean z16) {
                float f16 = i3 / 255.0f;
                if (this.last_fac < 0.0f) {
                    this.last_fac = f16;
                }
                if (Math.abs(this.last_fac - f16) < 0.1d) {
                    return;
                }
                this.last_fac = f16;
                float f17 = 3.0f * f16;
                FloatingView.this.editTextSharp.setText(String.valueOf(f17));
                FloatingView.this.switchFilter.setText(String.valueOf(f17));
                Log.v("VideoFilter", "2 switch factory: " + i3 + " fac:" + f16 + " last:" + VideoFilterController.get().isOpenTvesr() + " fac:" + VideoFilterController.get().getTvsrSharpFactor());
                VideoFilterController.get().setTvsrSharpFactor(f16);
                FloatingView.this.mView.clearFocus();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }
        });
        this.mWindowManager = FloatingManager.getInstance(this.mContext);
        this.editTextSharp.setText(String.valueOf(VideoFilterController.get().getTvsrSharpFactor() * 3.0f));
        this.seekSharp.setProgress((int) (VideoFilterController.get().getTvsrSharpFactor() * 255.0f));
        this.switchFilter.setChecked(VideoFilterController.get().isOpenTvesr());
        this.spinnerRecordLookback = (Spinner) this.mView.findViewById(R.id.spinnerRecordLookback);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(context, R.array.lookback_array, R.layout.simple_spinner_item);
        createFromResource.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spinnerRecordLookback.setAdapter((SpinnerAdapter) createFromResource);
        this.spinnerRecordLookback.setSelection(2, true);
        this.spinnerRecordLookback.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
                Toast.makeText(FloatingView.this.mContext, "lookback\uff1a" + adapterView.getItemAtPosition(i3), 0).show();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinnerRecordTimer = (Spinner) this.mView.findViewById(R.id.spinnerRecordTimer);
        ArrayAdapter<CharSequence> createFromResource2 = ArrayAdapter.createFromResource(context, R.array.rectimer_array, R.layout.simple_spinner_item);
        createFromResource2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spinnerRecordTimer.setAdapter((SpinnerAdapter) createFromResource2);
        this.spinnerRecordTimer.setSelection(2, true);
        this.spinnerRecordTimer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
                Toast.makeText(FloatingView.this.mContext, "Record Stopped after\uff1a" + adapterView.getItemAtPosition(i3), 0).show();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Switch r75 = (Switch) this.mView.findViewById(R.id.switchRtpRecord);
        this.switchRtpRecord = r75;
        r75.setOnCheckedChangeListener(new AnonymousClass6());
    }

    public void hide() {
        this.mWindowManager.removeView(this.mView);
    }

    public void setWebRTCSDK(WebRTCSDK webRTCSDK) {
        Log.v("VideoFilter", " setWebRTCSDK :" + this.sdk + " -- " + webRTCSDK);
        this.sdk = webRTCSDK;
    }

    public void show() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mParams = layoutParams;
        layoutParams.gravity = 53;
        layoutParams.x = 0;
        layoutParams.y = 100;
        layoutParams.type = 2038;
        layoutParams.format = 1;
        layoutParams.flags = 327968;
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mWindowManager.addView(this.mView, layoutParams);
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.FloatingView.7

            /* renamed from: x, reason: collision with root package name */
            private int f108092x;

            /* renamed from: y, reason: collision with root package name */
            private int f108093y;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 2) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int i3 = rawX - this.f108092x;
                        int i16 = rawY - this.f108093y;
                        this.f108092x = rawX;
                        this.f108093y = rawY;
                        FloatingView.this.mParams.x += i3;
                        FloatingView.this.mParams.y += i16;
                        FloatingView.this.mWindowManager.updateView(view, FloatingView.this.mParams);
                        Log.d("VideoFilter", "onTouch eagle:  " + FloatingView.this.mView.getLeft() + " " + FloatingView.this.mView.getTop() + " " + FloatingView.this.mView.getWidth() + " " + FloatingView.this.mView.getHeight());
                        return false;
                    }
                    return false;
                }
                this.f108092x = (int) motionEvent.getRawX();
                this.f108093y = (int) motionEvent.getRawY();
                return false;
            }
        });
    }
}
