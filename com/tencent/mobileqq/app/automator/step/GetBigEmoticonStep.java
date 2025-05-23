package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetBigEmoticonStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f195342a;

        /* renamed from: b, reason: collision with root package name */
        public int f195343b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GetBigEmoticonStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetBigEmoticonStep", 2, "doStep begins");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetBigEmoticonStep.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                File file = new File(AppConstants.SDCARD_EMOTICON_SAVE + "emojiIds.txt");
                if (!file.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GetBigEmoticonStep", 2, "doStep ends, file not exist.");
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONObject(FileUtils.readFileContent(file)).getJSONArray("data");
                    if (jSONArray != null && jSONArray.length() != 0) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            int i16 = jSONArray.getJSONObject(i3).getInt(EmojiManagerServiceProxy.EPID);
                            int i17 = jSONArray.getJSONObject(i3).getInt("type");
                            a aVar = new a();
                            aVar.f195342a = Integer.toString(i16);
                            aVar.f195343b = i17;
                            arrayList.add(aVar);
                        }
                        if (arrayList.size() == 0) {
                            return;
                        }
                        IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) ((Automator) GetBigEmoticonStep.this.mAutomator).E.getRuntimeService(IEmojiManagerService.class);
                        for (int i18 = 0; i18 < arrayList.size(); i18++) {
                            a aVar2 = (a) arrayList.get(i18);
                            EmoticonPackage emoticonPackage = new EmoticonPackage();
                            emoticonPackage.jobType = aVar2.f195343b;
                            emoticonPackage.epId = aVar2.f195342a;
                            iEmojiManagerService.pullEmoticonPackage(emoticonPackage, true);
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }, 5, null, false);
        return 7;
    }
}
