package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ChooseWindowItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.JoyPadItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.KeyItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.MoveItem;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.SDKSceneElement;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.SceneElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyMapSceneConfig implements IKeyMapSceneConfig {
    private int mId;
    public boolean mIsJoystickToMove;
    private boolean mIsSceneLeft;
    private int mKeyCombinationKeyCode;
    private String mSceneName;
    public float mTouchMapSensitivityX;
    public float mTouchMapSensitivityY;
    private int mPrimarySceneId = -1;
    private String[] mTGPASceneIds = null;
    private boolean mIsTGPAValid = true;
    private int mMapType = 0;
    private List<KeyMapKeyItem> mKeyConfig = new ArrayList();
    private List<KeyMapJoyPadItem> mJoypadConfig = new ArrayList();
    private List<KeyChooseWindowItem> mChooseWindowConfig = new ArrayList();
    private List<KeyMapKeyItem> mTouchButtonConfig = new ArrayList();
    private List<MoveItem> mKeyMoveConfig = new ArrayList();
    public PointF mTouchMapPos = new PointF();
    public PointF mSGameSkillsCancelPos = new PointF();
    private List<JoyKeyCancelItem> mJoyKeyCancelConfig = new ArrayList();

    private boolean isContainChooseWindowItem(KeyChooseWindowItem keyChooseWindowItem) {
        Iterator<KeyChooseWindowItem> it = this.mChooseWindowConfig.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == keyChooseWindowItem.getId()) {
                return true;
            }
        }
        return false;
    }

    public void addChooseWindowItem(KeyChooseWindowItem keyChooseWindowItem) {
        if (this.mChooseWindowConfig != null && keyChooseWindowItem != null && !isContainChooseWindowItem(keyChooseWindowItem)) {
            this.mChooseWindowConfig.add(keyChooseWindowItem);
        }
    }

    public void addJoyKeyItem(JoyKeyCancelItem joyKeyCancelItem) {
        List<JoyKeyCancelItem> list = this.mJoyKeyCancelConfig;
        if (list != null) {
            list.add(joyKeyCancelItem);
        }
    }

    public void addJoyPadItem(KeyMapJoyPadItem keyMapJoyPadItem) {
        this.mJoypadConfig.add(keyMapJoyPadItem);
    }

    public void addKeyItem(KeyMapKeyItem keyMapKeyItem) {
        List<KeyMapKeyItem> list = this.mKeyConfig;
        if (list != null) {
            list.add(keyMapKeyItem);
        }
    }

    public void addMoveItem(MoveItem moveItem) {
        List<MoveItem> list = this.mKeyMoveConfig;
        if (list != null) {
            list.add(moveItem);
        }
    }

    public void addTouchButtonItem(KeyMapKeyItem keyMapKeyItem) {
        List<KeyMapKeyItem> list = this.mTouchButtonConfig;
        if (list != null) {
            list.add(keyMapKeyItem);
        }
    }

    public void changeSceneElementCoordinate(ArrayList<SDKSceneElement> arrayList) {
        if (this.mKeyConfig != null && arrayList != null) {
            Iterator<SDKSceneElement> it = arrayList.iterator();
            while (it.hasNext()) {
                SDKSceneElement next = it.next();
                for (KeyMapKeyItem keyMapKeyItem : this.mKeyConfig) {
                    if (!TextUtils.isEmpty(next.path) && next.path.equals(keyMapKeyItem.getPath())) {
                        CGLog.i("path: " + next.path + " sceneElement.percent_x: " + next.percent_x + " sceneElement.percent_y: " + next.percent_y + " keyItem.percent_x: " + keyMapKeyItem.getPercentX() + " keyItem.percent_y: " + keyMapKeyItem.getPercentY());
                        float f16 = next.percent_x;
                        if (f16 > 0.0f) {
                            keyMapKeyItem.setPercentX(f16);
                        }
                        float f17 = next.percent_y;
                        if (f17 > 0.0f) {
                            keyMapKeyItem.setPercentY(f17);
                        }
                    }
                }
            }
        }
    }

    public void checkChooseWindowItemShowState(String str, int i3) {
        if (!TextUtils.isEmpty(str) && this.mChooseWindowConfig != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayFromString = CGJsonUtil.getJSONArrayFromString(str);
            if (jSONArrayFromString != null) {
                for (int i16 = 0; i16 < jSONArrayFromString.length(); i16++) {
                    try {
                        JSONObject jSONObject = (JSONObject) jSONArrayFromString.get(i16);
                        SceneElement sceneElement = new SceneElement();
                        sceneElement.showStatus = jSONObject.optInt("showStatus", 1);
                        sceneElement.isSwitchShow = jSONObject.optBoolean("isSwitchShow", false);
                        sceneElement.f108118id = jSONObject.optInt("id");
                        arrayList.add(sceneElement);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (this.mChooseWindowConfig != null && arrayList.size() > 0) {
                for (KeyChooseWindowItem keyChooseWindowItem : this.mChooseWindowConfig) {
                    if (keyChooseWindowItem.getIsSwitchShow()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            SceneElement sceneElement2 = (SceneElement) it.next();
                            if (sceneElement2.f108118id == keyChooseWindowItem.getId() && sceneElement2.isSwitchShow && sceneElement2.showStatus == 1) {
                                keyChooseWindowItem.setIsHide(false);
                            }
                        }
                    }
                }
            }
            if (i3 == 0) {
                for (KeyChooseWindowItem keyChooseWindowItem2 : this.mChooseWindowConfig) {
                    keyChooseWindowItem2.setIsHide(true);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        if (((SceneElement) it5.next()).f108118id == keyChooseWindowItem2.getId()) {
                            keyChooseWindowItem2.setIsHide(false);
                        }
                    }
                }
            }
        }
    }

    public void clear() {
        List<KeyMapKeyItem> list = this.mKeyConfig;
        if (list != null) {
            list.clear();
        }
        List<KeyMapJoyPadItem> list2 = this.mJoypadConfig;
        if (list2 != null) {
            list2.clear();
        }
        List<KeyChooseWindowItem> list3 = this.mChooseWindowConfig;
        if (list3 != null) {
            list3.clear();
        }
        List<KeyMapKeyItem> list4 = this.mTouchButtonConfig;
        if (list4 != null) {
            list4.clear();
        }
        List<MoveItem> list5 = this.mKeyMoveConfig;
        if (list5 != null) {
            list5.clear();
        }
        List<JoyKeyCancelItem> list6 = this.mJoyKeyCancelConfig;
        if (list6 != null) {
            list6.clear();
        }
    }

    public List<KeyChooseWindowItem> getChooseWindowConfig() {
        return this.mChooseWindowConfig;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public ChooseWindowItem getChooseWindowItem(int i3) {
        List<KeyChooseWindowItem> list = this.mChooseWindowConfig;
        if (list != null) {
            for (KeyChooseWindowItem keyChooseWindowItem : list) {
                if (keyChooseWindowItem.getId() == i3) {
                    return keyChooseWindowItem;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public int getConfigSize(int i3) {
        List<JoyKeyCancelItem> list;
        if (i3 == 1) {
            List<KeyMapJoyPadItem> list2 = this.mJoypadConfig;
            if (list2 != null) {
                return list2.size();
            }
        } else if (i3 == 2) {
            List<KeyMapKeyItem> list3 = this.mKeyConfig;
            if (list3 != null) {
                return list3.size();
            }
        } else if (i3 == 3) {
            List<KeyMapKeyItem> list4 = this.mTouchButtonConfig;
            if (list4 != null) {
                return list4.size();
            }
        } else if (i3 == 4) {
            List<KeyChooseWindowItem> list5 = this.mChooseWindowConfig;
            if (list5 != null) {
                return list5.size();
            }
        } else if (i3 == 5) {
            List<KeyMapKeyItem> list6 = this.mTouchButtonConfig;
            if (list6 != null) {
                return list6.size();
            }
        } else if (i3 == 6 && (list = this.mJoyKeyCancelConfig) != null) {
            return list.size();
        }
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public JoyKeyCancelItem getJoyKeyCancelItem(int i3) {
        List<JoyKeyCancelItem> list = this.mJoyKeyCancelConfig;
        if (list != null) {
            for (JoyKeyCancelItem joyKeyCancelItem : list) {
                if (joyKeyCancelItem.mBtnType == i3) {
                    return joyKeyCancelItem;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public JoyPadItem getJoyPadItem(int i3) {
        List<KeyMapJoyPadItem> list = this.mJoypadConfig;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public KeyItem getKeyItem(int i3) {
        List<KeyMapKeyItem> list = this.mKeyConfig;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public int getMapType() {
        return this.mMapType;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public MoveItem getMoveItem(int i3) {
        List<MoveItem> list = this.mKeyMoveConfig;
        if (list != null) {
            for (MoveItem moveItem : list) {
                if (moveItem.getMoveDirection() == i3) {
                    return moveItem;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public int getPrimarySceneId() {
        return this.mPrimarySceneId;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public String getSceneName() {
        return this.mSceneName;
    }

    public PointF getSceneTouchMapPos() {
        return this.mTouchMapPos;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public KeyChooseWindowItem getSelectKeyChooseWindowItem() {
        List<KeyChooseWindowItem> list = this.mChooseWindowConfig;
        if (list != null) {
            for (KeyChooseWindowItem keyChooseWindowItem : list) {
                if (keyChooseWindowItem.isSelect() && !keyChooseWindowItem.getIsHide()) {
                    return keyChooseWindowItem;
                }
            }
            return null;
        }
        return null;
    }

    public String[] getTGPASceneIds() {
        return this.mTGPASceneIds;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public KeyItem getTouchButtonItem(int i3) {
        List<KeyMapKeyItem> list = this.mTouchButtonConfig;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    public boolean hasCombinKey(int i3) {
        for (int i16 = 0; i16 < this.mKeyConfig.size(); i16++) {
            if (this.mKeyConfig.get(i16).hasConbinKey(i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasJoystickLConfig() {
        List<KeyMapJoyPadItem> list = this.mJoypadConfig;
        if (list != null) {
            for (KeyMapJoyPadItem keyMapJoyPadItem : list) {
                if (keyMapJoyPadItem != null && keyMapJoyPadItem.isValid() && keyMapJoyPadItem.getType() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasJoystickRConfig() {
        List<KeyMapJoyPadItem> list = this.mJoypadConfig;
        if (list != null) {
            for (KeyMapJoyPadItem keyMapJoyPadItem : list) {
                if (keyMapJoyPadItem != null && keyMapJoyPadItem.isValid() && keyMapJoyPadItem.getType() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCombinKey(int i3, int i16) {
        for (int i17 = 0; i17 < this.mKeyConfig.size(); i17++) {
            KeyMapKeyItem keyMapKeyItem = this.mKeyConfig.get(i17);
            if (keyMapKeyItem != null && keyMapKeyItem.isCombinKey(i3, i16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public boolean isIsSceneLeft() {
        return this.mIsSceneLeft;
    }

    public boolean isOneKey(int i3) {
        for (int i16 = 0; i16 < this.mKeyConfig.size(); i16++) {
            if (this.mKeyConfig.get(i16).isOneKey(i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public boolean isTGPAValid() {
        return this.mIsTGPAValid;
    }

    public void removeChooseWindowItem(KeyChooseWindowItem keyChooseWindowItem) {
        if (this.mChooseWindowConfig != null && keyChooseWindowItem != null && isContainChooseWindowItem(keyChooseWindowItem)) {
            this.mChooseWindowConfig.remove(keyChooseWindowItem);
        }
    }

    public void setId(int i3) {
        this.mId = i3;
    }

    public void setIsSceneLeft(boolean z16) {
        this.mIsSceneLeft = z16;
    }

    public void setMapType(int i3) {
        this.mMapType = i3;
    }

    public void setPrimarySceneId(int i3) {
        this.mPrimarySceneId = i3;
    }

    public void setSceneName(String str) {
        this.mSceneName = str;
    }

    public void setSceneTouchMapPos(float f16, float f17) {
        PointF pointF = this.mTouchMapPos;
        if (pointF != null) {
            pointF.x = f16;
            pointF.y = f17;
        }
    }

    public void setTGPASceneIds(String[] strArr) {
        this.mTGPASceneIds = strArr;
    }

    public void setTGPAValid(boolean z16) {
        this.mIsTGPAValid = z16;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public boolean updateSelectKeyChooseWindowItem(int i3) {
        if (this.mChooseWindowConfig == null) {
            return false;
        }
        for (int i16 = 0; i16 < this.mChooseWindowConfig.size(); i16++) {
            KeyChooseWindowItem keyChooseWindowItem = this.mChooseWindowConfig.get(i16);
            if (keyChooseWindowItem.getId() == i3) {
                keyChooseWindowItem.setSelect(true);
            } else {
                keyChooseWindowItem.setSelect(false);
            }
        }
        return true;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapSceneConfig
    public KeyMapKeyItem findTouchButtonItem(int i3) {
        if (this.mTouchButtonConfig != null) {
            for (int i16 = 0; i16 < this.mTouchButtonConfig.size(); i16++) {
                KeyMapKeyItem keyMapKeyItem = this.mTouchButtonConfig.get(i16);
                if (keyMapKeyItem != null && keyMapKeyItem.isOneKey(i3)) {
                    return keyMapKeyItem;
                }
            }
        }
        return null;
    }

    public KeyMapKeyItem getKeyItem(int i3, int i16, int i17) {
        if (this.mKeyConfig != null) {
            for (int i18 = 0; i18 < this.mKeyConfig.size(); i18++) {
                KeyMapKeyItem keyMapKeyItem = this.mKeyConfig.get(i18);
                if (keyMapKeyItem != null) {
                    if (i3 == 1) {
                        if (keyMapKeyItem.isOneKey(i16)) {
                            return keyMapKeyItem;
                        }
                    } else if (i3 == 2 && keyMapKeyItem.isCombinKey(i16, i17)) {
                        return keyMapKeyItem;
                    }
                }
            }
        }
        return null;
    }
}
