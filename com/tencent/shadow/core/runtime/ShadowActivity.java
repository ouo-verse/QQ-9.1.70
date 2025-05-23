package com.tencent.shadow.core.runtime;

import android.R;
import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.SharedElementCallback;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.heytap.databaseengine.type.DeviceType;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class ShadowActivity extends PluginActivity {
    private int mFragmentManagerHash;
    private PluginFragmentManager mPluginFragmentManager;

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mHostActivityDelegator.superAddContentView(view, layoutParams);
    }

    public <T extends View> T findViewById(int i3) {
        return (T) this.mHostActivityDelegator.findViewById(i3);
    }

    public void finishAffinity() {
        this.mHostActivityDelegator.finishAffinity();
    }

    public void finishAfterTransition() {
        this.mHostActivityDelegator.finishAfterTransition();
    }

    public ActionBar getActionBar() {
        return this.mHostActivityDelegator.getActionBar();
    }

    public final ShadowApplication getApplication() {
        return this.mPluginApplication;
    }

    public ComponentName getCallingActivity() {
        return this.mHostActivityDelegator.getCallingActivity();
    }

    public String getCallingPackage() {
        return this.mHostActivityDelegator.getCallingPackage();
    }

    public ComponentName getComponentName() {
        return this.mHostActivityDelegator.getComponentName();
    }

    public View getCurrentFocus() {
        return this.mHostActivityDelegator.getCurrentFocus();
    }

    public PluginFragmentManager getFragmentManager() {
        FragmentManager fragmentManager = this.mHostActivityDelegator.getFragmentManager();
        int identityHashCode = System.identityHashCode(fragmentManager);
        if (identityHashCode != this.mFragmentManagerHash) {
            this.mFragmentManagerHash = identityHashCode;
            this.mPluginFragmentManager = new PluginFragmentManager(fragmentManager);
        }
        return this.mPluginFragmentManager;
    }

    public Intent getIntent() {
        return this.mHostActivityDelegator.getIntent();
    }

    public Object getLastNonConfigurationInstance() {
        return this.mHostActivityDelegator.getLastNonConfigurationInstance();
    }

    public String getLocalClassName() {
        return getClass().getName();
    }

    public final MediaController getMediaController() {
        return this.mHostActivityDelegator.getMediaController();
    }

    public MenuInflater getMenuInflater() {
        return this.mHostActivityDelegator.getMenuInflater();
    }

    public final ShadowActivity getParent() {
        return null;
    }

    public Intent getParentActivityIntent() {
        return this.mHostActivityDelegator.getParentActivityIntent();
    }

    public SharedPreferences getPreferences(int i3) {
        return super.getSharedPreferences(getLocalClassName(), i3);
    }

    public Uri getReferrer() {
        return this.mHostActivityDelegator.getReferrer();
    }

    public int getRequestedOrientation() {
        return this.mHostActivityDelegator.getRequestedOrientation();
    }

    public CharSequence getTitle() {
        return this.mHostActivityDelegator.getTitle();
    }

    public final int getTitleColor() {
        return this.mHostActivityDelegator.getTitleColor();
    }

    public final int getVolumeControlStream() {
        return this.mHostActivityDelegator.getVolumeControlStream();
    }

    public Window getWindow() {
        return this.mHostActivityDelegator.getWindow();
    }

    public WindowManager getWindowManager() {
        return this.mHostActivityDelegator.getWindowManager();
    }

    public void invalidateOptionsMenu() {
        this.mHostActivityDelegator.invalidateOptionsMenu();
    }

    public boolean isDestroyed() {
        return this.mHostActivityDelegator.isDestroyed();
    }

    public boolean isFinishing() {
        return this.mHostActivityDelegator.isFinishing();
    }

    public boolean isInMultiWindowMode() {
        return this.mHostActivityDelegator.isInMultiWindowMode();
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mHostActivityDelegator.managedQuery(uri, strArr, str, strArr2, str2);
    }

    public boolean navigateUpTo(Intent intent) {
        return this.mHostActivityDelegator.navigateUpTo(this.mPluginComponentLauncher.convertPluginActivityIntent(intent));
    }

    public void overridePendingTransition(int i3, int i16) {
        if ((i3 & (-16777216)) != 16777216) {
            i3 = 0;
        }
        if (((-16777216) & i16) != 16777216) {
            i16 = 0;
        }
        this.mHostActivityDelegator.overridePendingTransition(i3, i16);
    }

    public void postponeEnterTransition() {
        this.mHostActivityDelegator.postponeEnterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.PluginActivity
    public void recreate() {
        this.mHostActivityDelegator.recreate();
    }

    public void registerActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks) {
        this.mShadowApplication.registerActivityLifecycleCallbacks(shadowActivityLifecycleCallbacks);
    }

    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        return this.mHostActivityDelegator.requestDragAndDropPermissions(dragEvent);
    }

    public final void requestPermissions(String[] strArr, int i3) {
        this.mHostActivityDelegator.requestPermissions(strArr, i3);
    }

    public final boolean requestWindowFeature(int i3) {
        return this.mHostActivityDelegator.requestWindowFeature(i3);
    }

    public void runOnUiThread(Runnable runnable) {
        this.mHostActivityDelegator.runOnUiThread(runnable);
    }

    public void setContentView(int i3) {
        if (DeviceType.DeviceCategory.MERGER.equals(XmlPullParserUtil.getLayoutStartTagName(getResources(), i3))) {
            LayoutInflater.from(this).inflate(i3, (ViewGroup) this.mHostActivityDelegator.getWindow().getDecorView().findViewById(R.id.content));
        } else {
            this.mHostActivityDelegator.setContentView(LayoutInflater.from(this).inflate(i3, (ViewGroup) null));
        }
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mHostActivityDelegator.setEnterSharedElementCallback(sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mHostActivityDelegator.setExitSharedElementCallback(sharedElementCallback);
    }

    public void setIntent(Intent intent) {
        this.mHostActivityDelegator.setIntent(intent);
    }

    public final void setMediaController(MediaController mediaController) {
        this.mHostActivityDelegator.setMediaController(mediaController);
    }

    public void setRequestedOrientation(int i3) {
        this.mHostActivityDelegator.setRequestedOrientation(i3);
    }

    public final void setResult(int i3) {
        this.mHostActivityDelegator.setResult(i3);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        this.mHostActivityDelegator.setTheme(i3);
    }

    public void setTitle(CharSequence charSequence) {
        this.mHostActivityDelegator.setTitle(charSequence);
    }

    public void setTitleColor(int i3) {
        this.mHostActivityDelegator.setTitleColor(i3);
    }

    public void setVisible(boolean z16) {
        this.mHostActivityDelegator.setVisible(z16);
    }

    public final void setVolumeControlStream(int i3) {
        this.mHostActivityDelegator.setVolumeControlStream(i3);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mHostActivityDelegator.shouldShowRequestPermissionRationale(str);
    }

    public boolean shouldUpRecreateTask(Intent intent) {
        return this.mHostActivityDelegator.shouldUpRecreateTask(this.mPluginComponentLauncher.convertPluginActivityIntent(intent));
    }

    public void startActivityForResult(Intent intent, int i3) {
        startActivityForResult(intent, i3, null);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        this.mHostActivityDelegator.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18);
    }

    public void startPostponedEnterTransition() {
        this.mHostActivityDelegator.startPostponedEnterTransition();
    }

    public final void setResult(int i3, Intent intent) {
        this.mHostActivityDelegator.setResult(i3, intent);
    }

    public void setTitle(int i3) {
        this.mHostActivityDelegator.setTitle(i3);
    }

    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        Intent intent2 = new Intent(intent);
        intent2.setExtrasClassLoader(this.mPluginClassLoader);
        if (this.mPluginComponentLauncher.startActivityForResult(this.mHostActivityDelegator, intent2, i3, bundle, new ComponentName(getPackageName(), getClass().getName()))) {
            return;
        }
        this.mHostActivityDelegator.startActivityForResult(intent, i3, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        this.mHostActivityDelegator.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    public void setContentView(View view) {
        this.mHostActivityDelegator.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mHostActivityDelegator.setContentView(view, layoutParams);
    }
}
